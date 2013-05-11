package com.heroku.any

import scala.io.Source
import spray.json._
import com.heroku.any.schema._
import DefaultJsonProtocol._
import com.heroku.any.HerokuApiProtocol._
import java.io.{FileOutputStream, PrintWriter, File}
import com.squareup.java.JavaWriter
import java.lang.reflect.Modifier._

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

  def convertType(raw: String) = raw match {
    case "string"   => "String"
    case "datetime" => "java.util.Date"
    case "uuid"     => "java.util.UUID"
    case other => other
  }

  def prettyMethod(raw: String) = {
    // TODO
    raw
  }

  def genResource(resourceName: String, resourceDetail: Resource) {
    val out = new PrintWriter(new FileOutputStream(s"target/generated/com/heroku/api/${resourceName}.java"))
    val writer = new JavaWriter(out)

    val java = writer.emitPackage("com.heroku")
      .beginType(s"com.heroku.${resourceName.replace(" ", "")}", "class", PUBLIC | FINAL)

    resourceDetail.attributes.foreach { case (attributeName: String, attributeDetail: Attribute) =>
      java.emitField(convertType(attributeDetail.`type`), attributeName, PUBLIC | FINAL)
    }

    java.emitEmptyLine()

    resourceDetail.attributes.foreach { case (attributeName: String, attributeDetail: Attribute) =>
      java.beginMethod(convertType(attributeDetail.`type`), s"get${prettyMethod(attributeName)}", PUBLIC)
        .emitStatement(s"return $attributeName")
        .endMethod()
    }

//      java.emitJavadoc(resourceDetail.description)

    java.endType()

    out.flush()
    out.close()
  }

  def main(args: Array[String]) {
    {
      for {
        schemaFilename <- parseFilename(args).right
        schemaFile     <- loadFile(schemaFilename).right
        schema         <- deserialize(schemaFile).right
      } yield {
        schema.resources.foreach { case (name: String, resource: Resource) =>
          println(name)
          genResource(name, resource)
        }

        schema
      }
    }
//      .fold(printError, println)
  }
}
