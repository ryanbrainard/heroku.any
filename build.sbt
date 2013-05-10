import com.typesafe.sbt.SbtStartScript

seq(SbtStartScript.startScriptForClassesSettings: _*)

name := "heroku.any"

version := "1.0"

scalaVersion := "2.10.1"

resolvers += "spray" at "http://repo.spray.io/"

libraryDependencies ++= Seq(
  "com.squareup" % "javawriter" % "1.0.5",
  "io.spray" %%  "spray-json" % "1.2.3"
)
