name := "SimpleAkkaSorter"
version := "1.0"
scalaVersion := "2.12.4"
description := "Sorter with Akka Router"

libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.5.9",
    "com.typesafe.akka" %% "akka-stream" % "2.5.9",
    "com.typesafe.akka" %% "akka-http" % "10.1.0-RC2",
    "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.0-RC2"
)