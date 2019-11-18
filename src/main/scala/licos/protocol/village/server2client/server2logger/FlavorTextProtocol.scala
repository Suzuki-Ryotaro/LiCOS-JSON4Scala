package licos.protocol.village.server2client.server2logger

import licos.entity.Village
import licos.json.element.village.JsonFlavorText
import licos.json.element.village.iri.{BaseContext, Context, FlavorTextContext, FlavorTextMessage}
import licos.knowledge.{FlavorText, PublicChannel, ServerToClient}
import licos.protocol.village.part.character.StatusCharacterProtocol
import licos.protocol.village.part.{BaseProtocol, ChatSettingsProtocol, VillageProtocol}
import licos.util.TimestampGenerator

final case class FlavorTextProtocol(
    village:                    Village,
    flavorText:                 Seq[licos.protocol.village.server2client.ChatFromServerProtocol],
    extensionalDisclosureRange: Seq[StatusCharacterProtocol]
) {

  val json: Option[JsonFlavorText] = {
    village.currentPhase = FlavorText
    if (village.isAvailable) {
      Option(
        new JsonFlavorText(
          BaseProtocol(
            Seq[Context](BaseContext, FlavorTextContext),
            FlavorTextMessage,
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
            Option(TimestampGenerator.now),
            None,
            ServerToClient,
            PublicChannel,
            extensionalDisclosureRange,
            Nil,
            Nil
          ).json,
          flavorText.flatMap(_.json)
        )
      )
    } else {
      None
    }
  }

}
