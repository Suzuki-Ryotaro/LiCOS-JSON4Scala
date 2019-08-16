package engine.lobby.analysis

import engine.lobby.LobbyBox
import engine.lobby.example.Ping
import element.JsonTest
import licos.json.element.lobby.JsonPing
import licos.json.engine.BOX
import licos.json.engine.analysis.lobby.server2client.PingAnalysisEngine
import play.api.libs.json.{JsValue, Json}

class PingAE extends PingAnalysisEngine {
  override def process(box: BOX, ping: JsonPing): Option[JsValue] = {
    box match {
      case _: LobbyBox => Option(Json.toJson(JsonTest(Ping.`type`)))
      case _ => None
    }
  }
}