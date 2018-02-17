package com.shoesorter.api

import akka.actor._
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import com.shoesorter.domain.Domain._
import com.shoesorter.messages.Messages._
import com.shoesorter.messages.JsonSupport
import com.shoesorter.util.Decisions
import akka.pattern.ask
import akka.util.Timeout

trait RestInterface extends JsonSupport {

    def createDecisionActor: ActorRef

    lazy val decisionActor: ActorRef = createDecisionActor

    def createTimeout: Timeout 

    lazy implicit val mytimeout = createTimeout

    val route: Route = {
        path("junctions" / IntNumber / "decisionForContainer" / IntNumber) { (junctionId, containerId) =>
            get {
                complete {
                    val junction = Junction(junctionId)
                    val container = Container(containerId)
                    //Go(Decisions.whereShouldContainerGo(junction, container))
                    (decisionActor ? WhereShouldIGo(junction, container)).mapTo[Go]
                    
                }
            }
        }
    }

   // def receive: Receive = ???
}