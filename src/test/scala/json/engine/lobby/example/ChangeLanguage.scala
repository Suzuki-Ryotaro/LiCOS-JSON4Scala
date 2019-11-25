package json.engine.lobby.example

import json.engine.ClientToServerLobbyExample

final case class ChangeLanguage(filePath: String) extends ClientToServerLobbyExample(filePath) {
  override val `type`: String = ChangeLanguage.`type`
}

object ChangeLanguage {
  val `type`: String = "ChangeLanguage"
}
