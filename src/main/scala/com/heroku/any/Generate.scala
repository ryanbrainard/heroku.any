package com.heroku.any

import scala.io.Source
import spray.json._
import com.heroku.any.schema._
import DefaultJsonProtocol._
import com.heroku.any.HerokuApiProtocol._
import java.io.File

object Generate {

  def parseFilename(args: Array[String]) = {
    if (args.length == 1) Right(args(0))
    else Left("Must specify doc.json location as only parameter")
  }

  def loadFile(filename: String) = {
    val file = new File(filename)
    if (file.exists()) Right(file)
    else Left(s"File not found: $file")
  }

  def deserialize(file: File) = try {
    Right(Source.fromFile(file).mkString.asJson.asJsObject.convertTo[Schema])
  } catch {
    case e:DeserializationException => Left(s"Problem parsing schema:${e.getMessage}")
  }

  def printError(msg: String) {
    System.err.println(s"ERROR: $msg")
  }

  def main(args: Array[String]) {
    {
      for {
        schemaFilename <- parseFilename(args).right
        schemaFile     <- loadFile(schemaFilename).right
        schema         <- deserialize(schemaFile).right
      } yield {
        schema
      }
    }.fold(printError, println)
  }
}
