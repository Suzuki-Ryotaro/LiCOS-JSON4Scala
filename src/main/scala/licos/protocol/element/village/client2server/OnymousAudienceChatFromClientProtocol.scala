package licos.protocol.element.village.client2server

import java.net.URL

import licos.entity.{VillageInfo, VillageInfoFactory, VillageInfoFromLobby}
import licos.json.element.village.JsonOnymousAudienceChat
import play.api.libs.json.{JsValue, Json}

final case class OnymousAudienceChatFromClientProtocol(
    village:       VillageInfo,
    text:          String,
    myAvatarName:  String,
    myAvatarImage: URL
) extends Client2ServerVillageMessageProtocol {

  private val json: Option[JsonOnymousAudienceChat] = {
    server2logger.OnymousAudienceChatFromClientProtocol(village, text, myAvatarName, myAvatarImage, Nil).json
  }

  override def toJsonOpt: Option[JsValue] = {
    json map { j: JsonOnymousAudienceChat =>
      Json.toJson(j)
    }
  }

}

object OnymousAudienceChatFromClientProtocol {

  def read(
      json:                 JsonOnymousAudienceChat,
      villageInfoFromLobby: VillageInfoFromLobby
  ): Option[OnymousAudienceChatFromClientProtocol] = {
    if (!json.isFromServer) {
      VillageInfoFactory.create(villageInfoFromLobby, json.base) match {
        case Some(village: VillageInfo) =>
          Some(
            OnymousAudienceChatFromClientProtocol(
              village,
              json.text.`@value`,
              json.avatar.name,
              new URL(json.avatar.image)
            )
          )
        case None => None
      }
    } else {
      None
    }
  }

}
