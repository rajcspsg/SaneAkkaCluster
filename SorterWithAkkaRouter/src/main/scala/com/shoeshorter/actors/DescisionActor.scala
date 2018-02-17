package com.shoesorter.actors

import akka.actor._
import com.shoesorter.util.Decisions
import com.shoesorter.domain.Domain._
import com.shoesorter.messages.Messages._
import akka.util.Timeout

class DescisionActor extends Actor {
    
    override def receive: Receive = {
        case (junction: Junction, container: Container) => 
            sender() ! Decisions.whereShouldContainerGo(junction, container)
        case WhereShouldIGo(junction, container) => 
            sender() ! Decisions.whereShouldContainerGo(junction, container)
    }
}

object DescisionActor {
    def props(implicit timeout: Timeout) = Props(new DescisionActor())

    def name = "decisionActor"
}