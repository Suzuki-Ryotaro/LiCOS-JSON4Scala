package json.engine.village.unitTestExample

import json.engine.VillageUnitTestExample

final case class SubErrorFromServer(filePath: String) extends VillageUnitTestExample(filePath) {
  override val `type`: String = SubErrorFromServer.`type`
}

object SubErrorFromServer {
  val `type`: String = "unitTest/SubErrorFromServer"
}
