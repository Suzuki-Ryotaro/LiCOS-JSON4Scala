package licos.protocol.element.lobby.server2server

import java.util.UUID

import licos.json.element.lobby.server2client.JsonPlayed
import licos.json.element.lobby.server2server.JsonPlayedWithToken
import licos.protocol.element.lobby.server2client.PlayedProtocol
import play.api.libs.json.{JsValue, Json}

@SuppressWarnings(Array[String]("org.wartremover.warts.OptionPartial"))
final case class PlayedWithTokenProtocol(to: UUID, json: PlayedProtocol) extends Server2ServerLobbyMessageProtocol {

  private val json_ : Option[JsonPlayedWithToken] = {
    val played: Option[JsonPlayed] = json.json

    if (played.nonEmpty) {
      Some(
        JsonPlayedWithToken(
          to.toString,
          played.get
        )
      )
    } else {
      None
    }
  }

  override def toJsonOpt: Option[JsValue] = {
    json_ map { j: JsonPlayedWithToken =>
      Json.toJson(j)
    }
  }

}

object PlayedWithTokenProtocol {

  @SuppressWarnings(Array[String]("org.wartremover.warts.OptionPartial"))
  def read(json: JsonPlayedWithToken): Option[PlayedWithTokenProtocol] = {

    val played: Option[PlayedProtocol] = PlayedProtocol.read(json.json)

    if (played.nonEmpty) {
      Some(
        PlayedWithTokenProtocol(
          UUID.fromString(json.to),
          played.get
        )
      )
    } else {
      None
    }
  }

}
