package protocol.engine.lobby.analysis.client2server

import licos.protocol.element.lobby.LobbyMessageProtocol
import licos.protocol.element.lobby.client2server.ChangeUserNameProtocol
import licos.protocol.engine.analysis.lobby.client2server.ChangeUserNameAnalysisEngine
import licos.protocol.engine.processing.lobby.{LobbyBOX, LobbyBOXNotFoundException}
import protocol.element.LobbyMessageTestProtocol
import protocol.engine.lobby.example.client2server.ChangeUserName
import protocol.engine.lobby.LobbyBox

import scala.util.{Failure, Success, Try}

final class ChangeUserNameAE extends ChangeUserNameAnalysisEngine {
  override def process(box: LobbyBOX, changeUserNameProtocol: ChangeUserNameProtocol): Try[LobbyMessageProtocol] = {
    box match {
      case _: LobbyBox => Success(LobbyMessageTestProtocol(ChangeUserName.`type`))
      case _ => Failure(new LobbyBOXNotFoundException())
    }
  }
}
