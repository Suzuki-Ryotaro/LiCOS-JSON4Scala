package json.engine.lobby.example

import json.engine.ServerToClientLobbyExample

final case class Ping(filePath: String) extends ServerToClientLobbyExample(filePath) {
  override val `type`: String = Ping.`type`
}

object Ping {
  val `type`: String = "Ping"
}
