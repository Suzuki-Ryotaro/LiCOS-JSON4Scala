package json.engine.lobby.example

import json.engine.ClientToServerLobbyExample

final case class EnterLobby(filePath: String) extends ClientToServerLobbyExample(filePath) {
  override val `type`: String = EnterLobby.`type`
}

object EnterLobby {
  val `type`: String = "EnterLobby"
}
