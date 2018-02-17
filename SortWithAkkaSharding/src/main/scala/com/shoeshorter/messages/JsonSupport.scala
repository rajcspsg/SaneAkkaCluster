package com.shoesorter.messages


import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._
import Messages._

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val goJson = jsonFormat1(Go)
}