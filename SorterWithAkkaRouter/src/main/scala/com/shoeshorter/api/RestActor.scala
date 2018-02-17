package com.shoesorter.api

import akka.actor._
import akka.util.Timeout
import com.shoesorter.actors._

class RestActor(system: ActorSystem, timeout: Timeout) extends RestInterface {
    implicit val requestTimeout = timeout
    implicit val executionContext = system.dispatcher

    def createDecisionActor: ActorRef = system.actorOf(DeciderGaurdianActor.props, DeciderGaurdianActor.name)

    def createTimeout: Timeout = timeout
}