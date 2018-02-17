name := "AkkaClusterSharding"

version:= "1.0"

scalaVersion := "2.12.4"

lazy val simpleAkkaSorter = (project in file("SimpleAkkaSorter")).settings(
    name := "SimpleAkkaSorter",
    version := "1.0",
    scalaVersion := "2.12.4",
    description := "Simple Sorter with standalone Akka Actor"
)

lazy val akkaSorterWithRouter = (project in file("SorterWithAkkaRouter")).settings(
    name := "SimpleAkkaSorter",
    version := "1.0",
    scalaVersion := "2.12.4",
    description := "Sorter with Akka Router"
)

lazy val sortWithAkkaSharding = (project in file("SortWithAkkaSharding")).settings(
    name := "SortWithAkkaSharding",
    version := "1.0",
    scalaVersion := "2.12.4",
    description := "SorterWithAkkaSharding"
)

