package engine.lobby.example

import engine.ServerToClientLobbyExample

case class WaitingPage(filePath: String) extends ServerToClientLobbyExample(filePath) {
  override val `type`: String = WaitingPage.`type`
}

object WaitingPage {
  val `type`: String = "WaitingPage"
}