package json.engine.lobby.example

import json.engine.ClientToServerLobbyExample

final case class LeaveWaitingPage(filePath: String) extends ClientToServerLobbyExample(filePath) {
  override val `type`: String = LeaveWaitingPage.`type`
}

object LeaveWaitingPage {
  val `type`: String = "LeaveWaitingPage"
}
