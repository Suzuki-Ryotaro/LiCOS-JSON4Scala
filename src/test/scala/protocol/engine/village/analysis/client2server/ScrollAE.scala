package protocol.engine.village.analysis.client2server

import licos.protocol.element.village.VillageMessageProtocol
import licos.protocol.element.village.client2server.ScrollProtocol
import licos.protocol.engine.analysis.village.client2server.ScrollAnalysisEngine
import licos.protocol.engine.processing.village.VillageBOX
import protocol.element.VillageMessageTestProtocol
import protocol.engine.village.example.client2server.Scroll
import protocol.engine.village.{NoVillageBOXException, VillageBox}

import scala.util.{Failure, Success, Try}

final class ScrollAE extends ScrollAnalysisEngine {
  override def process(box: VillageBOX, scroll: ScrollProtocol): Try[VillageMessageProtocol] = {
    box match {
      case _: VillageBox => Success(VillageMessageTestProtocol(Scroll.`type`))
      case _ => Failure(new NoVillageBOXException())
    }
  }
}
