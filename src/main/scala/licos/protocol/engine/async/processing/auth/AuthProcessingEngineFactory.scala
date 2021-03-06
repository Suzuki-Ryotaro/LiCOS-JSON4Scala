package licos.protocol.engine.async.processing.auth

import licos.protocol.engine.async.analysis.auth.robot2server.AuthenticationAndAuthorizationRequestAnalysisEngine
import licos.protocol.engine.async.analysis.auth.server2robot.{
  AuthenticationRequestResponseAnalysisEngine,
  AuthorizationRequestResponseAnalysisEngine
}
import licos.protocol.engine.async.processing.ProcessingEngineFactory

@SuppressWarnings(Array[String]("org.wartremover.warts.Overloading", "org.wartremover.warts.Var"))
class AuthProcessingEngineFactory extends ProcessingEngineFactory {
  private var authenticationAndAuthorizationRequestEngine: Option[AuthenticationAndAuthorizationRequestAnalysisEngine] =
    None
  private var authenticationRequestResponseEngine: Option[AuthenticationRequestResponseAnalysisEngine] = None
  private var authorizationRequestResponseEngine:  Option[AuthorizationRequestResponseAnalysisEngine]  = None

  override def create: AuthProcessingEngine = {
    new AuthProcessingEngine(
      authenticationAndAuthorizationRequestEngine,
      authenticationRequestResponseEngine,
      authorizationRequestResponseEngine
    )
  }

  def set(
      authenticationAndAuthorizationRequestEngine: AuthenticationAndAuthorizationRequestAnalysisEngine
  ): AuthProcessingEngineFactory = {
    this.authenticationAndAuthorizationRequestEngine = Option(authenticationAndAuthorizationRequestEngine)
    this
  }

  def set(
      authenticationRequestResponseAnalysisEngine: AuthenticationRequestResponseAnalysisEngine
  ): AuthProcessingEngineFactory = {
    this.authenticationRequestResponseEngine = Option(authenticationRequestResponseAnalysisEngine)
    this
  }

  def set(
      authorizationRequestResponseAnalysisEngine: AuthorizationRequestResponseAnalysisEngine
  ): AuthProcessingEngineFactory = {
    this.authorizationRequestResponseEngine = Option(authorizationRequestResponseAnalysisEngine)
    this
  }
}
