import com.typesafe.sbt.SbtStartScript

seq(SbtStartScript.startScriptForJarSettings: _*)

name := "heroku.any"

version := "1.0"

scalaVersion := "2.10.1"

scalacOptions ++= Seq("-feature")

resolvers += "spray" at "http://repo.spray.io/"

libraryDependencies ++= Seq(
  "org.rogach" %% "scallop" % "0.9.1",
  "com.squareup" % "javawriter" % "1.0.5",
  "org.fusesource.scalate" %% "scalate-core" % "1.6.1",
  "org.slf4j" % "slf4j-nop" % "1.6.1",
  "io.spray" %%  "spray-json" % "1.2.3",
  "com.sun.jersey" % "jersey-client" % "1.17.1",
  "com.sun.jersey" % "jersey-json" % "1.17.1",
  "org.scalatest" %% "scalatest" % "2.0.M6-SNAP16" % "test"
)
