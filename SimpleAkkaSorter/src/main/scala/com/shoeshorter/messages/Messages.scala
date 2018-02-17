package com.shoesorter.messages

import spray.json.DefaultJsonProtocol
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._
import akka.http.scaladsl.marshalling.Marshal
import akka.http.scaladsl.model._
import com.shoesorter.domain.Domain._

object Messages extends DefaultJsonProtocol {
    case class Go(conveyor: String) 
    case class WhereShouldIGo(junction: Junction, container: Container)
    implicit val goJson = jsonFormat1(Go)
}
