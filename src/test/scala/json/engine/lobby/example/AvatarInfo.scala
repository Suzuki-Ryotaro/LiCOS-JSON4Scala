package json.engine.lobby.example

import json.engine.ServerToClientLobbyExample

final case class AvatarInfo(filePath: String) extends ServerToClientLobbyExample(filePath) {
  override val `type`: String = AvatarInfo.`type`
}

object AvatarInfo {
  val `type`: String = "AvatarInfo"
}
