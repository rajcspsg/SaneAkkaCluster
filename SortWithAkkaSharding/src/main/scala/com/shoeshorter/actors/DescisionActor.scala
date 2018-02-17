package com.shoesorter.actors

import akka.actor._
import com.shoesorter.util.Decisions
import com.shoesorter.domain.Domain._
import com.shoesorter.messages.Messages._
import akka.util.Timeout
import akka.cluster.sharding.ShardRegion
import akka.cluster.sharding.ShardRegion.{ExtractEntityId, ExtractShardId}

class DescisionActor extends Actor {
    
    override def receive: Receive = {
        case (junction: Junction, container: Container) => {
            sender() ! Decisions.whereShouldContainerGo(junction, container)
        }
    }
}

object DescisionActor {

    def props(implicit timeout: Timeout) = Props(new DescisionActor())

    def name = "decisionActor"

    def extractShardId: ExtractShardId = {
        case WhereShouldIGo(junction, _) =>
        (junction.id % 2).toString
    }

    def extractEntityId: ExtractEntityId = {
        case msg @ WhereShouldIGo(junction, _) =>
        (junction.id.toString, msg)
    }
    
}