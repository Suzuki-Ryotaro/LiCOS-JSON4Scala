package licos.protocol.element.lobby.server2client

import java.util.Locale

import licos.json.element.lobby.JsonPlayed
import play.api.libs.json.{JsValue, Json}

final case class PlayedProtocol(lang: Locale) extends Server2ClientLobbyMessageProtocol {

  val json: Option[JsonPlayed] = {
    Some(
      new JsonPlayed(
        lang.getLanguage
      )
    )
  }

  override def toJsonOpt: Option[JsValue] = json.map(Json.toJson)

}

object PlayedProtocol {

  def read(json: JsonPlayed): Option[PlayedProtocol] = {
    Some(
      PlayedProtocol(
        new Locale(json.lang)
      )
    )
  }

}
