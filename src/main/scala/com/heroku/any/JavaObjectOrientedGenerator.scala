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
    generateApi(schema, srcRoot)
    schema.resources.foreach { resource: Resource =>
      generateAction(resource, srcRoot)
      generateModel(resource, srcRoot)
    }
  }

  private def generateConnectionConstructor(writer: JavaWriter, className: String) = {
    writer
      .emitField("Connection", "connection", PRIVATE | FINAL)
      .emitEmptyLine()
      .beginMethod(null, className, PROTECTED, "Connection", "connection")
      .emitStatement("this.connection = connection")
      .endMethod()
      .emitEmptyLine()
  }

  private def generateApi(schema: Schema, srcRoot: File) {
    val apiClass = "HerokuApi"
    val out = new PrintWriter(new FileOutputStream(s"$srcRoot/$apiClass.java"))
    val writer = new JavaWriter(out)

    // header
    val cls = writer
      .emitPackage(packageName)
      .beginType(packageName + "." + apiClass, "class", PUBLIC | FINAL)
      .emitEmptyLine()

    generateConnectionConstructor(writer, apiClass)

    schema.resources.foreach { resource =>
      cls
        .emitJavadoc(s"Perform ${resource.name} Actions")
        .beginMethod(resource.actionsClassName, TextUtils.camelCase(resource.actionsClassName), PUBLIC)
        .emitStatement(s"return new ${resource.actionsClassName}(connection)")
        .endMethod()
        .emitEmptyLine()
    }

    cls.endType()
    out.flush()
    out.close()
  }

  private def generateAction(resource: Resource, srcRoot: File) {
    val out = new PrintWriter(new FileOutputStream(s"$srcRoot/${resource.actionsClassName}.java"))
    val writer = new JavaWriter(out)

    // header
    writer
      .emitPackage(packageName)
      .beginType(packageName + "." + resource.actionsClassName, "class", PUBLIC | FINAL)
      .emitEmptyLine()

    generateConnectionConstructor(writer, resource.actionsClassName)

    resource.actions.foreach { action =>
      val param = TextUtils.camelCase(resource.modelClassName)
      val returnType = if (action.returnable) resource.modelClassName else "void"
      val returnKeyword = if (action.returnable) "return " else ""
      writer
        .emitJavadoc(s"${action.httpMethod} ${resource.modelClassName}")
        .beginMethod(returnType, action.methodName, PUBLIC, resource.modelClassName, param)
        .emitStatement(s"${returnKeyword}connection.execute($param)")
        .endMethod()
        .emitEmptyLine()
    }

    writer.endType()
    out.flush()
    out.close()
  }

  private def generateModel(resource: Resource, srcRoot: File) {
    val out = new PrintWriter(new FileOutputStream(s"$srcRoot/${resource.modelClassName}.java"))
    val writer = new JavaWriter(out)

    // header
    writer
      .emitPackage(packageName)
      .beginType(packageName + "." + resource.modelClassName, "class", PUBLIC | FINAL)

    // fields
    resource.attributes.foreach { attribute: Attribute =>
      writer
        .emitEmptyLine()
        .emitJavadoc(TextUtils.capitalize(attribute.description))
        .emitField(attribute.dataType, attribute.name, PRIVATE | FINAL)
    }

    writer.emitEmptyLine()

    // empty constructor
    writer
      .emitJavadoc(s"Construct empty ${resource.name}")
      .beginMethod(null, resource.modelClassName, PUBLIC)
      .endMethod()
      .emitEmptyLine()

    // fully-qualified constructor
    writer.beginMethod(null, resource.modelClassName, PUBLIC, resource.attributes.map { attribute: Attribute =>
        Seq[String](attribute.dataType, attribute.fieldName)
    }.flatten.toSeq:_*)
    resource.attributes.foreach { attribute: Attribute =>
      writer.emitStatement(s"this.${attribute.fieldName} = ${attribute.fieldName}")
    }
    writer.endMethod().emitEmptyLine()

    // getters and setters
    resource.attributes.foreach { attribute: Attribute =>
      writer
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

    writer.endType()
    out.flush()
    out.close()
  }

  private implicit def dataTypesForJava(dataType: DataType):String = dataType.raw match {
    case "string"   => "String"
    case "number"   => "Number"
    case "datetime" => "java.util.Date"
    case "uuid"     => "java.util.UUID"
    case other =>      other
  }
}
