package engine.lobby.analysis

import engine.lobby.LobbyBox
import engine.lobby.example.WaitingPage
import element.JsonTest
import licos.json.element.lobby.JsonWaitingPage
import licos.json.engine.BOX
import licos.json.engine.analysis.lobby.server2client.WaitingPageAnalysisEngine
import play.api.libs.json.{JsValue, Json}

class WaitingPageAE extends WaitingPageAnalysisEngine {
  override def process(box: BOX, waitingPage: JsonWaitingPage): Option[JsValue] = {
    box match {
      case _: LobbyBox => Option(Json.toJson(JsonTest(WaitingPage.`type`)))
      case _ => None
    }
  }
}