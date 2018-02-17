package com.shoesorter.actors

import akka.actor._
import com.shoesorter.util.Decisions
import com.shoesorter.domain.Domain._
import com.shoesorter.messages.Messages._
import akka.util.Timeout

class DeciderGaurdianActor extends Actor {
    override def receive: Receive = {
        case msg: WhereShouldIGo => 
        val name = s"J${msg.junction.id}"
        val actor = context.child(name) getOrElse context.actorOf(Props[DescisionActor], name)
        actor forward msg
    }
}