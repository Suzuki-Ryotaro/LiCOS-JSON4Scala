package licos.protocol.element.village.server2client

import licos.entity.{VillageInfo, VillageInfoFactory, VillageInfoFromLobby}
import licos.json.element.village.character.JsonCharacter
import licos.json.element.village.role.JsonRole
import licos.json.element.village.server2client.JsonPhase
import licos.json.element.village.{JsonBoardResult, JsonVotingResultSummary}
import licos.knowledge.{Character, Data2Knowledge, Morning, Phase, PolarityMark, Role, Status}
import licos.protocol.element.village.part.{BoardResultProtocol, UpdateProtocol, VotingResultSummaryProtocol}
import licos.protocol.element.village.part.character.CharacterProtocol
import licos.protocol.element.village.part.role.RoleProtocol
import play.api.libs.json.{JsValue, Json}

import scala.collection.mutable.ListBuffer

final case class MorningPhaseProtocol(
    village:              VillageInfo,
    character:            Seq[CharacterProtocol],
    role:                 Seq[RoleProtocol],
    votingResultsSummary: Seq[VotingResultSummaryProtocol]
) extends Server2ClientVillageMessageProtocol {

  private val json: Option[JsonPhase] = {
    server2logger.MorningPhaseProtocol(village, character, role, Nil, votingResultsSummary, Nil).json
  }

  override def toJsonOpt: Option[JsValue] = {
    json map { j: JsonPhase =>
      Json.toJson(j)
    }
  }

}

object MorningPhaseProtocol {

  @SuppressWarnings(
    Array[String](
      "org.wartremover.warts.Any",
      "org.wartremover.warts.OptionPartial",
      "org.wartremover.warts.MutableDataStructures"
    )
  )
  def read(json: JsonPhase, villageInfoFromLobby: VillageInfoFromLobby): Option[MorningPhaseProtocol] = {
    import cats.implicits._
    if (json.base.phase === Morning.label && 1 < json.base.day) {
      VillageInfoFactory.create(villageInfoFromLobby, json.base) match {
        case Some(village: VillageInfo) =>
          val characterBuffer = ListBuffer.empty[CharacterProtocol]
          val roleBuffer      = ListBuffer.empty[RoleProtocol]

          json.character foreach { jsonCharacter: JsonCharacter =>
            val characterOpt: Option[Character] = Data2Knowledge.characterOpt(jsonCharacter.name.en, jsonCharacter.id)
            val phaseOpt:     Option[Phase]     = Data2Knowledge.phaseOpt(jsonCharacter.update.phase)
            if (characterOpt.nonEmpty && phaseOpt.nonEmpty) {
              val statusOpt: Option[Status] = Data2Knowledge.statusOpt(jsonCharacter.status)
              if (statusOpt.nonEmpty) {
                characterBuffer += CharacterProtocol(
                  characterOpt.get,
                  village.id,
                  village.language,
                  jsonCharacter.isMine,
                  statusOpt.get,
                  UpdateProtocol(
                    phaseOpt.get,
                    jsonCharacter.update.day
                  ),
                  jsonCharacter.isAChoice
                )
              }
            }
          }

          json.role foreach { jsonRole: JsonRole =>
            val roleOpt: Option[Role] = Data2Knowledge.roleOpt(jsonRole.name.en, jsonRole.numberOfPlayers)
            if (roleOpt.nonEmpty) {
              val boardResultBuffer = ListBuffer.empty[BoardResultProtocol]
              jsonRole.board foreach { jsonBoardResult: JsonBoardResult =>
                val characterOpt: Option[Character] =
                  Data2Knowledge.characterOpt(jsonBoardResult.character.name.en, jsonBoardResult.character.id)
                val polarityOpt: Option[PolarityMark] = Data2Knowledge.polarityMarkOpt(jsonBoardResult.polarity)
                val phaseOpt:    Option[Phase]        = Data2Knowledge.phaseOpt(jsonBoardResult.phase)

                if (characterOpt.nonEmpty && polarityOpt.nonEmpty && phaseOpt.nonEmpty) {
                  boardResultBuffer += BoardResultProtocol(
                    characterOpt.get,
                    polarityOpt.get,
                    phaseOpt.get,
                    jsonBoardResult.day,
                    village.id,
                    village.language
                  )
                }
              }

              roleBuffer += RoleProtocol(
                roleOpt.get,
                jsonRole.isMine,
                jsonRole.numberOfPlayers,
                boardResultBuffer.result,
                village.id,
                village.language
              )
            }
          }

          val votingResultSummaryBuffer = ListBuffer.empty[VotingResultSummaryProtocol]
          json.base.votingResultsSummary foreach { summaries: Seq[JsonVotingResultSummary] =>
            summaries foreach { jsonVotingResultSummary: JsonVotingResultSummary =>
              val characterOpt: Option[Character] = Data2Knowledge.characterOpt(
                jsonVotingResultSummary.characterToPutToDeath.name.en,
                jsonVotingResultSummary.characterToPutToDeath.id
              )
              if (characterOpt.nonEmpty) {
                votingResultSummaryBuffer += VotingResultSummaryProtocol(
                  characterOpt.get,
                  jsonVotingResultSummary.numberOfVotes,
                  jsonVotingResultSummary.rankOfVotes,
                  village.id,
                  village.language
                )
              }
            }
          }

          Some(
            MorningPhaseProtocol(
              village,
              characterBuffer.result,
              roleBuffer.result,
              votingResultSummaryBuffer.result
            )
          )
        case None => None
      }
    } else {
      None
    }
  }

}
