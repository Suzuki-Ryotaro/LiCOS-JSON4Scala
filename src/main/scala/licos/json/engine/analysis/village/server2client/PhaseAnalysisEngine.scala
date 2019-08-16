package licos.json.engine.analysis.village.server2client

import licos.json.engine.BOX
import licos.json.engine.analysis.AnalysisEngine
import licos.json.element.village.JsonPhase
import play.api.libs.json.JsValue

/** The analysis engine for a phase.
  *
  * @author Kotaro Sakamoto
  */
trait PhaseAnalysisEngine extends AnalysisEngine {

  /** Returns a play.api.libs.json.JsValue response from a JSON message.
    *
    * @param box a box.
    * @param phase a JSON message.
    * @return a play.api.libs.json.JsValue option.
    */
  def process(box: BOX, phase: JsonPhase): Option[JsValue]
}