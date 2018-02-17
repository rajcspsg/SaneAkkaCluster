package com.shoesorter.main

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn
import com.shoesorter.api._
import scala.concurrent.duration.{Duration, FiniteDuration}

object Webserver extends App  {

    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()

    lazy val requestTimeout = FiniteDuration(5, scala.concurrent.duration.SECONDS)
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher
    val route = new RestActor(system, requestTimeout).route
    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  
}