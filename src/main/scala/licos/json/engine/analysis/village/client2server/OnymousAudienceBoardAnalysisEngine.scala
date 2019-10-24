package licos.json.engine.analysis.village.client2server

import licos.json.element.village.JsonOnymousAudienceBoard
import licos.json.engine.BOX
import licos.json.engine.analysis.AnalysisEngine
import play.api.libs.json.JsValue

/** The analysis engine for onymous audience board.
  *
  * @author Kotaro Sakamoto
  */
trait OnymousAudienceBoardAnalysisEngine extends AnalysisEngine {

  /** Returns a play.api.libs.json.JsValue response from a JSON message.
    *
    * @param box a box.
    * @param onymousAudienceBoard a JSON message.
    * @return a play.api.libs.json.JsValue option.
    */
  def process(box: BOX, onymousAudienceBoard: JsonOnymousAudienceBoard): Option[JsValue]
}