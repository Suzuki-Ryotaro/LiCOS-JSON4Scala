package licos.protocol.village.client2server

import licos.entity.Village
import licos.json.element.lobby.JsonLeaveWaitingPage
import licos.knowledge.Lobby

final case class LeaveWaitingPageProtocol(village: Village) {

  def json(lobby: Lobby): Option[JsonLeaveWaitingPage] = {
    if (village.isAvailable) {
      Option(
        new JsonLeaveWaitingPage(
          village.tokenOpt.get.toString,
          village.id,
          lobby.label
        )
      )
    } else {
      None
    }
  }

}
