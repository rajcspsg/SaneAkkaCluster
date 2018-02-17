package com.shoesorter.api

import akka.actor._
import akka.util.Timeout
import com.shoesorter.actors.DescisionActor

class RestActor(system: ActorSystem, timeout: Timeout) extends RestInterface {
    implicit val requestTimeout = timeout
    implicit val executionContext = system.dispatcher

    def createDecisionActor: ActorRef = system.actorOf(DescisionActor.props, DescisionActor.name)

    def createTimeout: Timeout = timeout
}