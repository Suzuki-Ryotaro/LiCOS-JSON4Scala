package protocol.engine.lobby.analysis.server2server

import licos.protocol.element.lobby.LobbyMessageProtocol
import licos.protocol.element.lobby.server2server.PlayedWithTokenProtocol
import licos.protocol.engine.analysis.lobby.server2server.PlayedWithTokenAnalysisEngine
import licos.protocol.engine.processing.lobby.{LobbyBOX, LobbyBOXNotFoundException}
import protocol.element.LobbyMessageTestProtocol
import protocol.engine.lobby.example.server2server.PlayedWithToken
import protocol.engine.lobby.LobbyBox

import scala.util.{Failure, Success, Try}

final class PlayedWithTokenAE extends PlayedWithTokenAnalysisEngine {
  override def process(box: LobbyBOX, playedWithTokenProtocol: PlayedWithTokenProtocol): Try[LobbyMessageProtocol] = {
    box match {
      case _: LobbyBox => Success(LobbyMessageTestProtocol(PlayedWithToken.`type`))
      case _ => Failure(new LobbyBOXNotFoundException())
    }
  }
}
