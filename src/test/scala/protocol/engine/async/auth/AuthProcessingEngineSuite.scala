package protocol.engine.async.auth

import java.nio.charset.StandardCharsets

import com.typesafe.scalalogging.Logger
import licos.json.parser.AuthParser
import licos.json2protocol.auth.Json2AuthMessageProtocol
import licos.protocol.element.auth.AuthMessageProtocol
import licos.protocol.engine.async.processing.auth.{AuthProcessingEngine, AuthProcessingEngineFactory}
import licos.protocol.engine.async.processing.{AuthPE, SpecificProcessingEngineFactory}
import org.junit.experimental.theories.{DataPoints, Theories, Theory}
import org.junit.runner.RunWith
import org.scalatest.junit.AssertionsForJUnit
import play.api.libs.json.Json
import protocol.element.AuthMessageTestProtocol
import protocol.engine.AuthExample
import protocol.engine.async.auth.analysis.robot2server.AuthenticationAndAuthorizationRequestAE
import protocol.engine.async.auth.analysis.server2robot.{
  AuthenticationRequestResponseAE,
  AuthorizationRequestResponseAE
}
import protocol.engine.auth.AuthBox
import protocol.engine.auth.example.robot2server.AuthenticationAndAuthorizationRequest
import protocol.engine.auth.example.server2robot.{AuthenticationRequestResponse, AuthorizationRequestResponse}

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.io.{Codec, Source}

object AuthProcessingEngineSuite {
  @DataPoints
  def exampleSeq: Array[AuthExample] = Array[AuthExample](
    AuthenticationAndAuthorizationRequest("authenticationAndAuthorizationRequest.json"),
    AuthenticationRequestResponse("authenticationRequestResponse.json"),
    AuthorizationRequestResponse("authorizationRequestResponse.json")
  )
}

@RunWith(classOf[Theories])
class AuthProcessingEngineSuite extends AssertionsForJUnit with AuthParser {

  private final val log: Logger = Logger[AuthProcessingEngineSuite]

  private val processingEngineFactory: AuthProcessingEngineFactory = SpecificProcessingEngineFactory
    .create(AuthPE)
    .asInstanceOf[AuthProcessingEngineFactory]
    .set(new AuthenticationAndAuthorizationRequestAE())
    .set(new AuthenticationRequestResponseAE())
    .set(new AuthorizationRequestResponseAE())

  private val processingEngine: AuthProcessingEngine = processingEngineFactory.create

  @Theory
  def process(jsonExample: AuthExample): Unit = {
    val jsonType:       String = jsonExample.`type`
    val url:            String = jsonExample.path
    implicit val codec: Codec  = Codec(StandardCharsets.UTF_8)
    log.info(url)
    val source = Source.fromURL(url)
    val msg: String = source.getLines.mkString("\n")
    source.close()
    log.debug(msg)

    import scala.concurrent.ExecutionContext.Implicits.global

    Json2AuthMessageProtocol.toProtocolOpt(Json.parse(msg)) match {
      case Some(protocol: AuthMessageProtocol) =>
        Await.ready(
          processingEngine
            .process(new AuthBox(), protocol)
            .map { messageProtocol: AuthMessageProtocol =>
              messageProtocol match {
                case p: AuthMessageTestProtocol =>
                  assert(p.text == jsonType)
                case _ =>
                  fail(
                    Seq[String](
                      "No AuthMessageTestProtocol"
                    ).mkString("\n")
                  )
              }
            }
            .recover {
              case error: Exception =>
                fail(
                  Seq[String](
                    "No response is generated.",
                    error.getMessage,
                    msg
                  ).mkString("\n")
                )
            },
          Duration.Inf
        )
      case _ =>
        fail(
          Seq[String](
            "No protocol"
          ).mkString("\n")
        )
    }
  }
}
