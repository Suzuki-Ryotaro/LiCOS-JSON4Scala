package licos.protocol.village.client2server.server2logger

import licos.entity.Village
import licos.json.element.village.JsonError
import licos.json.element.village.iri.{BaseContext, ChatContext, ChatMessage, Context}
import licos.knowledge.{ClientToServer, PrivateChannel, Severity}
import licos.protocol.village.part.character.StatusCharacterProtocol
import licos.protocol.village.part.{BaseProtocol, ChatSettingsProtocol, NameProtocol, VillageProtocol}
import licos.util.TimestampGenerator

final case class ErrorFromClientProtocol(
    village:                    Village,
    content:                    NameProtocol,
    severity:                   Severity,
    source:                     String,
    extensionalDisclosureRange: Seq[StatusCharacterProtocol]
) {

  val json: Option[JsonError] = {
    if (village.isAvailable) {
      Option(
        new JsonError(
          BaseProtocol(
            Seq[Context](BaseContext, ChatContext),
            ChatMessage,
            VillageProtocol(
              village.id,
              village.name,
              village.cast.totalNumberOfPlayers,
              village.language,
              ChatSettingsProtocol(
                village.id,
                village.maxNumberOfChatMessages,
                village.maxLengthOfUnicodeCodePoints
              )
            ),
            village.tokenOpt.get,
            village.currentPhase,
            village.currentDay,
            village.currentPhase.timeLimit(village.currentDay, village.numberOfAlivePlayers).get,
            village.phaseStartTimeOpt.get,
            None,
            Option(TimestampGenerator.now),
            ClientToServer,
            PrivateChannel,
            extensionalDisclosureRange,
            Nil,
            Nil
          ).json,
          content.json(Option(village.language)),
          severity.label,
          source,
          isFromServer = false
        )
      )
    } else {
      None
    }
  }

}
