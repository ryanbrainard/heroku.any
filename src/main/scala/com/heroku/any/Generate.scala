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
    case "number"   => "Number"
    case "datetime" => "java.util.Date"
    case "uuid"     => "java.util.UUID"
    case other => other
  }

  def genResource(resourceName: String, resourceDetail: Resource) {
    val out = new PrintWriter(new FileOutputStream(s"target/generated/com/heroku/api/${resourceName}.java"))
    val writer = new JavaWriter(out)

    // header
    val resourceClass = writer
      .emitPackage("com.heroku")
      .beginType(s"com.heroku.${resourceName.replace(" ", "")}", "class", PUBLIC | FINAL)

    // fields
    resourceDetail.attributes.foreach { case (attributeName: String, attributeDetail: Attribute) =>
      resourceClass
        .emitEmptyLine()
        .emitJavadoc(TextUtils.capitalize(attributeDetail.description))
        .emitField(convertType(attributeDetail.`type`), attributeName, PRIVATE | FINAL)
    }

    resourceClass.emitEmptyLine()

    // empty constructor
    resourceClass
      .emitJavadoc(s"Construct empty $resourceName")
      .beginMethod(null, resourceName, PUBLIC)
      .endMethod()
      .emitEmptyLine()

    // fully-qualified constructor
    resourceClass.beginMethod(null, resourceName, PUBLIC, resourceDetail.attributes.map {
      case (attributeName: String, attributeDetail: Attribute) =>
        Seq(convertType(attributeDetail.`type`), TextUtils.camelCase(attributeName))
    }.flatten.toSeq:_*)
    resourceDetail.attributes.map { case (attributeName: String, attributeDetail: Attribute) =>
      resourceClass.emitStatement(s"this.$attributeName = ${TextUtils.camelCase(attributeName)}")
      Seq(convertType(attributeDetail.`type`), TextUtils.camelCase(attributeName))
    }
    resourceClass.endMethod().emitEmptyLine()

    // getters and setters
    resourceDetail.attributes.foreach { case (attributeName: String, attributeDetail: Attribute) =>
      val uType = convertType(attributeDetail.`type`)
      val uField = TextUtils.capitalCamelCase(attributeName)
      resourceClass
        .emitJavadoc(s"Get ${attributeDetail.description}")
        .beginMethod(uType, s"get$uField", PUBLIC)
        .emitStatement(s"return this.$attributeName")
        .endMethod()
        .emitEmptyLine()
        .emitJavadoc(s"Set ${attributeDetail.description}")
        .beginMethod(uType, s"set$uField", PROTECTED, uType, uField)
        .emitStatement(s"this.$attributeName = $uField")
        .endMethod()
        .emitEmptyLine()
    }

    resourceClass.endType()

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
