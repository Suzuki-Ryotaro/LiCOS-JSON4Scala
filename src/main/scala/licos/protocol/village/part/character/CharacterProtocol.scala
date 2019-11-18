package licos.protocol.village.part.character

import java.util.Locale

import licos.json.element.village.character.JsonCharacter
import licos.json.element.village.iri.CharacterContext
import licos.knowledge.{Character, Status}
import licos.protocol.village.part.UpdateProtocol
import licos.util.LiCOSOnline

final case class CharacterProtocol(
    character: Character,
    villageId: Long,
    lang:      Locale,
    isMine:    Boolean,
    status:    Status,
    update:    UpdateProtocol,
    isAChoice: Boolean
) {

  private val `@id`: String = LiCOSOnline.state(villageId, s"character#${character.intId}")

  val json: JsonCharacter = JsonCharacter(
    CharacterContext.iri,
    `@id`,
    character.intId,
    character.name.json(Option(lang)),
    character.icon,
    isMine,
    status.label,
    update.json(`@id`),
    isAChoice
  )

}
