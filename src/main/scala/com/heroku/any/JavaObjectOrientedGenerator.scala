package com.heroku.any

import com.heroku.any.schema.rich._
import java.io.{File, FileOutputStream, PrintWriter}
import com.squareup.java.JavaWriter
import java.lang.reflect.Modifier._

class JavaObjectOrientedGenerator extends Generator {

  val packagePath = "/com/heroku/api"
  val packageName = "com.heroku.api"

  def generate(schema: Schema, root: File) {
    val srcRoot = new File(root, packagePath)
    srcRoot.mkdirs()
    schema.resources.foreach { resource: Resource =>
      genResource(resource, srcRoot)
    }
  }

  private implicit def dataTypesForJava(dataType: DataType):String = dataType.raw match {
    case "string"   => "String"
    case "number"   => "Number"
    case "datetime" => "java.util.Date"
    case "uuid"     => "java.util.UUID"
    case other =>      other
  }

  private def genResource(resource: Resource, srcRoot: File) {
    val out = new PrintWriter(new FileOutputStream(s"$srcRoot/${resource.modelClassName}.java"))
    val writer = new JavaWriter(out)

    // header
    val resourceClass = writer
      .emitPackage(packageName)
      .beginType(packageName + "." + resource.modelClassName, "class", PUBLIC | FINAL)

    // fields
    resource.attributes.foreach { attribute: Attribute =>
      resourceClass
        .emitEmptyLine()
        .emitJavadoc(TextUtils.capitalize(attribute.description))
        .emitField(attribute.dataType, attribute.name, PRIVATE | FINAL)
    }

    resourceClass.emitEmptyLine()

    // empty constructor
    resourceClass
      .emitJavadoc(s"Construct empty ${resource.name}")
      .beginMethod(null, resource.modelClassName, PUBLIC)
      .endMethod()
      .emitEmptyLine()

    // fully-qualified constructor
    resourceClass.beginMethod(null, resource.modelClassName, PUBLIC, resource.attributes.map { attribute: Attribute =>
        Seq[String](attribute.dataType, attribute.fieldName)
    }.flatten.toSeq:_*)
    resource.attributes.foreach { attribute: Attribute =>
      resourceClass.emitStatement(s"this.${attribute.fieldName} = ${attribute.fieldName}")
    }
    resourceClass.endMethod().emitEmptyLine()

    // getters and setters
    resource.attributes.foreach { attribute: Attribute =>
      resourceClass
        .emitJavadoc(s"Get ${attribute.description}")
        .beginMethod(attribute.dataType, s"get${TextUtils.capitalize(attribute.fieldName)}", PUBLIC)
        .emitStatement(s"return this.${attribute.fieldName}")
        .endMethod()
        .emitEmptyLine()
        .emitJavadoc(s"Set ${attribute.description}")
        .beginMethod(attribute.dataType, s"set${TextUtils.capitalize(attribute.fieldName)}", PROTECTED, attribute.dataType, attribute.fieldName)
        .emitStatement(s"this.${attribute.fieldName} = ${attribute.fieldName}")
        .endMethod()
        .emitEmptyLine()
    }

    resourceClass.endType()

    out.flush()
    out.close()
  }
}
