name := "SortWithAkkaSharding"
version := "1.0"
scalaVersion := "2.12.4"
description := "SorterWithAkkaSharding"

libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.5.9",
    "com.typesafe.akka" %% "akka-stream" % "2.5.9",
    "com.typesafe.akka" %% "akka-http" % "10.1.0-RC2",
    "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.0-RC2"
)

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-cluster
libraryDependencies += "com.typesafe.akka" %% "akka-cluster" % "2.5.9"

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-remote
libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.5.9"

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-cluster-tools
libraryDependencies += "com.typesafe.akka" %% "akka-cluster-tools" % "2.5.9"

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-cluster-sharding
libraryDependencies += "com.typesafe.akka" %% "akka-cluster-sharding" % "2.5.9"

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-distributed-data
libraryDependencies += "com.typesafe.akka" %% "akka-distributed-data" % "2.5.9"
