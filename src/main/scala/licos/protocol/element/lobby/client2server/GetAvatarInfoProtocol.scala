package licos.protocol.element.lobby.client2server

import java.util.UUID

import licos.json.element.lobby.JsonGetAvatarInfo
import play.api.libs.json.{JsValue, Json}

final case class GetAvatarInfoProtocol(token: UUID) extends Client2ServerLobbyMessageProtocol {

  private val json: Option[JsonGetAvatarInfo] = {
    Some(
      new JsonGetAvatarInfo(
        token.toString
      )
    )
  }

  override def toJsonOpt: Option[JsValue] = json.map(Json.toJson)

}

object GetAvatarInfoProtocol {

  def read(json: JsonGetAvatarInfo): Option[GetAvatarInfoProtocol] = {
    Some(
      GetAvatarInfoProtocol(
        UUID.fromString(json.token)
      )
    )
  }

}
