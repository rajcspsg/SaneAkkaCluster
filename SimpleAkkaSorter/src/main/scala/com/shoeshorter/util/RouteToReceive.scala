/*
package com.shoesorter.util

import scala.util.control.NonFatal
import akka.actor._
import akka.io.Tcp
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import com.shoesorter.domain.Domain._

class RouteToReceive {

     def runRoute(route: Route)(implicit eh: ExceptionHandler, rh: RejectionHandler, ac: ActorContext,
                             rs: RoutingSettings, log: LoggingContext): Actor.Receive = {
    val sealedExceptionHandler = eh orElse ExceptionHandler.default
    val sealedRoute = sealRoute(route)(sealedExceptionHandler, rh)
    def runSealedRoute(ctx: RequestContext): Unit =
      try sealedRoute(ctx)
      catch {
        case NonFatal(e) ⇒
          val errorRoute = sealedExceptionHandler(e)
          errorRoute(ctx)
      }

    {
      case request: HttpRequest ⇒
        val ctx = RequestContext(request, ac.sender(), request.uri.path).withDefaultSender(ac.self)
        runSealedRoute(ctx)

      case ctx: RequestContext ⇒ runSealedRoute(ctx)

      case Tcp.Connected(_, _) ⇒
        // by default we register ourselves as the handler for a new connection
        ac.sender() ! Tcp.Register(ac.self)

      case x: Tcp.ConnectionClosed        ⇒ onConnectionClosed(x)

      case Timedout(request: HttpRequest) ⇒ runRoute(timeoutRoute)(eh, rh, ac, rs, log)(request)
    }
  }

    /**
   * Called by the `runRoute` behavior when a `ConnectionClosed` event is received.
   * Override with custom logic if required (by default the method does nothing).
   */
  def onConnectionClosed(ev: Tcp.ConnectionClosed): Unit = ()

  /**
   * "Seals" a route by wrapping it with exception handling and rejection conversion.
   */
  def sealRoute(route: Route)(implicit eh: ExceptionHandler, rh: RejectionHandler): Route =
    (handleExceptions(eh) & handleRejections(sealRejectionHandler(rh)))(route)

  def sealRejectionHandler(rh: RejectionHandler): RejectionHandler =
    rh orElse RejectionHandler.Default orElse handleUnhandledRejections

  def handleUnhandledRejections: RejectionHandler.PF = {
    case x :: _ ⇒ sys.error("Unhandled rejection: " + x)
  }

  //# timeout-route
  def timeoutRoute: Route = complete(
    InternalServerError,
    "The server was not able to produce a timely response to your request.")
}

*/