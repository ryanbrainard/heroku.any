package com.heroku.any

import com.heroku.any.schema._
import java.io.{FileOutputStream, PrintWriter}
import com.squareup.java.JavaWriter
import java.lang.reflect.Modifier._
import com.heroku.any.schema.Resource
import com.heroku.any.schema.Schema

class JavaObjectOrientedGenerator extends Generator {

  def generate(schema: Schema) {
    schema.resources.foreach { case (name: String, resource: Resource) =>
      genResource(name, resource)
    }
  }

  private def genResource(resourceName: String, resourceDetail: Resource) {
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

  private def convertType(raw: String) = raw match {
    case "string"   => "String"
    case "number"   => "Number"
    case "datetime" => "java.util.Date"
    case "uuid"     => "java.util.UUID"
    case other => other
  }
}
