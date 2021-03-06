package licos.protocol.element.village.server2client

import licos.json.element.village.invite.JsonNextGameInvitation
import play.api.libs.json.{JsValue, Json}

final case class NextGameInvitationProtocol(villageId: Long) extends Server2ClientVillageMessageProtocol {

  private val json: Option[JsonNextGameInvitation] = {
    Some(new JsonNextGameInvitation(villageId))
  }

  override def toJsonOpt: Option[JsValue] = {
    json map { j: JsonNextGameInvitation =>
      Json.toJson(j)
    }
  }

}

object NextGameInvitationProtocol {

  def read(json: JsonNextGameInvitation): Option[NextGameInvitationProtocol] = {
    Some(NextGameInvitationProtocol(json.villageId))
  }

}
