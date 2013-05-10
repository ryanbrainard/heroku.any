import com.typesafe.sbt.SbtStartScript

seq(SbtStartScript.startScriptForClassesSettings: _*)

name := "heroku.any"

version := "1.0"

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
  "com.squareup" % "javawriter" % "1.0.5"
)
