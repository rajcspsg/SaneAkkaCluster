package com.shoesorter.main

import akka.cluster.sharding.{ClusterSharding, ClusterShardingSettings}
import akka.actor._
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn
import com.shoesorter.api._
import scala.concurrent.duration.{Duration, FiniteDuration}
import com.shoesorter.actors.DescisionActor
import com.typesafe.config.ConfigFactory
import akka.util.Timeout

object Webserver extends App  {

  val config = ConfigFactory.load("sharded")
  implicit val system = ActorSystem(config getString "application.name", config)
  
  lazy implicit val requestTimeout = FiniteDuration(5, scala.concurrent.duration.SECONDS)

  import scala.concurrent.duration._
  implicit val timeout = Timeout(10 seconds)

  ClusterSharding(system).start(
    typeName = DescisionActor.name,
    entityProps = DescisionActor.props,
    settings = ClusterShardingSettings(system),
    extractShardId = DescisionActor.extractShardId,
    extractEntityId = DescisionActor.extractEntityId
  )

   val decider = ClusterSharding(system).shardRegion(DescisionActor.name)

   // system.actorOf(Props.create(RestActor.class, system, requestTimeout, ""))
   system.actorOf(Props(classOf[RestActor], system, requestTimeout))
   
}