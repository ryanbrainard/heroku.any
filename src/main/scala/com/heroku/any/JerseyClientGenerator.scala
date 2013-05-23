package com.heroku.any

import com.heroku.any.schema.rich._
import java.io.{File, FileOutputStream, PrintWriter}
import com.squareup.java.JavaWriter
import java.lang.reflect.Modifier._
import scala.language.implicitConversions

class JerseyClientGenerator extends Generator with Templating {

  val packagePath = "/com/heroku/api"
  val packageName = "com.heroku.api"

  val name = "jersey-client"

  def generate(schema: Schema, root: File) {
    val srcRoot = new File(root, s"/src/main/java/$packagePath")
    copyTemplates(root)
    (schema.resources ++ schema.resourcesSecondClass).foreach { resource: Resource =>
      if (resource.isModel) generateModel(resource, srcRoot)
      resource.actions.foreach { action =>
        generateResourceActionClass(action, srcRoot)
      }
    }
  }

  private def generateResourceActionClass(action: Action, srcRoot: File) {
    val out = new PrintWriter(new FileOutputStream(s"$srcRoot/${action.className}.java"))
    val writer = new JavaWriter(out)

    // header
    writer
      .emitPackage(packageName)
      .emitAnnotation(classOf[org.codehaus.jackson.map.annotate.JsonSerialize])
      .beginType(packageName + "." + action.className, "class", PUBLIC | FINAL, null, s"Action<${dataTypesForJava(action.responseDataType)}>")
      .emitEmptyLine()

    action.topLevelAttributes.foreach { a =>
      if (action.pathAttributes.contains(a)) writer.emitAnnotation(classOf[org.codehaus.jackson.annotate.JsonIgnore])
      writer.emitField(a.dataType, a.fieldName, PRIVATE)
    }

    writer
      .emitEmptyLine()
      .beginMethod(null, action.className, PUBLIC, action.requiredAttributes.flatMap(a => Seq[String](a.dataType, a.paramName)):_*)
      action.requiredAttributes.foreach(a => writer.emitStatement(s"this.${a.fieldName} = ${a.paramName}"))
      writer
        .endMethod()
        .emitEmptyLine()

    writer
      .beginMethod(dataTypesForJava(action.responseDataType), "execute", PUBLIC, "Connection", "connection")
      .emitStatement("return connection.execute(this)")
      .endMethod()
      .emitEmptyLine()

    if (action.name.equalsIgnoreCase("list")) {
      writer
        .beginMethod(s"Iterable<${dataTypesForJava(action.resource.modelClassName)}>", "executeList", PUBLIC, "Connection", "connection")
        .emitStatement("return connection.executeList(this)")
        .endMethod()
        .emitEmptyLine()
    }

    writer
      .beginMethod("String", "httpMethod", PUBLIC)
      .emitStatement("return \"" + action.httpMethod + "\"")
      .endMethod()
      .emitEmptyLine()

    writer
      .beginMethod("String", "path", PUBLIC)
      .emitStatement("return \"" + action.path + "\"" + action.pathAttributes.map(a => ".replace(\"" + a.description + "\", " + a.name + ")").mkString)
      .endMethod()
      .emitEmptyLine()

    val requestEntity = action.requestEntity match {
      case NullRequestEntity => "null"
      case ActionRequestEntity => "this"
      case AttributeRequestEntity(attribute: Attribute) => attribute.fieldName
    }

    writer
      .beginMethod("Object", "requestEntity", PUBLIC)
      .emitStatement(s"return $requestEntity")
      .endMethod()
      .emitEmptyLine()

    writer
      .beginMethod("java.util.Collection<Integer>", "expectedStatuses", PUBLIC)
      .emitStatement(s"return java.util.Arrays.asList(${action.statuses.mkString(",")})")
      .endMethod()
      .emitEmptyLine()

    writer
      .beginMethod(s"com.sun.jersey.api.client.GenericType<${dataTypesForJava(action.responseDataType)}>", "responseType", PUBLIC)
      .emitStatement(s"return new com.sun.jersey.api.client.GenericType<${dataTypesForJava(action.responseDataType)}>(){}")
      .endMethod()

    action.topLevelAttributes.foreach { a =>
      writer
        .emitEmptyLine()
        .beginMethod(a.dataType, s"get${a.paramName.capitalize}", PUBLIC)
        .emitStatement(s"return this.${a.fieldName}")
        .endMethod()
    }

    action.optionalAttributes.map(_.massaged).toSet.foreach { a: Attribute =>
      writer
        .emitEmptyLine()
        .emitJavadoc(s"Set ${a.description}")
        .beginMethod(action.className, s"set${a.paramName.capitalize}", PUBLIC, a.dataType, a.paramName)
        .emitStatement(s"this.${a.fieldName} = ${a.paramName}")
        .emitStatement("return this")
        .endMethod()
    }

    writer.endType()
    out.flush()
    out.close()
  }

  private def generateModel(resource: Resource, srcRoot: File) {
    val out = new PrintWriter(new FileOutputStream(s"$srcRoot/${dataTypesForJava(resource.modelClassName)}.java"))
    val writer = new JavaWriter(out)

    // header
    writer
      .emitPackage(packageName)
      .beginType(packageName + "." + dataTypesForJava(resource.modelClassName), "class", PUBLIC, null, "java.io.Serializable")
      .emitEmptyLine()
      .emitField("long", "serialVersionUID", PROTECTED | FINAL | STATIC, s"${resource.hashCode}L")

    // fields
    resource.serializableAttributes.foreach { attribute: Attribute =>
      writer
        .emitEmptyLine()
        .emitJavadoc(attribute.description.capitalize)
        .emitAnnotation(classOf[org.codehaus.jackson.annotate.JsonProperty])
        .emitField(attribute.dataType, attribute.fieldName, PRIVATE)
    }

    writer.emitEmptyLine()

    // empty constructor
    writer
      .emitJavadoc(s"${resource.name} is created in response to API calls")
      .beginMethod(null, resource.modelClassName, PROTECTED)
      .endMethod()
      .emitEmptyLine()

    // getters
    resource.serializableAttributes.foreach { attribute: Attribute =>
      writer
        .emitJavadoc(s"Get ${attribute.description}")
        .beginMethod(attribute.dataType, s"get${attribute.paramName.capitalize}", PUBLIC)
        .emitStatement(s"return this.${attribute.fieldName}")
        .endMethod()
        .emitEmptyLine()
    }

    // equals
    val model = dataTypesForJava(resource.modelClassName).toLowerCase
    writer
      .emitAnnotation("Override")
      .beginMethod("boolean", "equals", PUBLIC, "Object", "o")
      .emitStatement("if (this == o) return true")
      .emitStatement(" if (o == null || getClass() != o.getClass()) return false")
      .emitEmptyLine()
      .emitStatement(s"${dataTypesForJava(resource.modelClassName)} $model = (${dataTypesForJava(resource.modelClassName)}) o")
      .emitEmptyLine()
      resource.serializableAttributes.foreach { attribute =>
        if (attribute.dataType.raw.head.isLower /* primitive */) {
          writer.emitStatement(s"if (${attribute.fieldName} != $model.${attribute.fieldName}) return false")
        } else {
          writer.emitStatement(s"if (${attribute.fieldName} != null ? !${attribute.fieldName}.equals($model.${attribute.fieldName}) : $model.${attribute.fieldName} != null) return false")
        }
      }
      writer
        .emitStatement("return true")
        .endMethod()
        .emitEmptyLine()

    // hashCode
    writer
      .emitAnnotation("Override")
      .beginMethod("int", "hashCode", PUBLIC)
      .emitStatement("return id != null ? id.hashCode() : 0")
      .endMethod()
      .emitEmptyLine()

    // toString
    writer
      .emitAnnotation("Override")
      .beginMethod("String", "toString", PUBLIC)
      .emitStatement(resource.serializableAttributes.map { attribute: Attribute =>
      (s""""${attribute.paramName}='" + ${attribute.fieldName} + '\\'' +""")
      }.mkString(
        s"""return "${dataTypesForJava(resource.modelClassName)}{" + \n""",
        "\n\", \" + ",
        "\n'}'"))
        .endMethod()
        .emitEmptyLine()

    writer.endType()
    out.flush()
    out.close()
  }

  private implicit def dataTypesForJava(dataType: DataType):String = {
    val listPattern = """list\[(\w+)\]""".r
    val dictPattern = """dictionary\[(\w+),(\w+)\]""".r

    dataType.raw match {
      case "string"         => "String"
      case "number"         => "Number"
      case "datetime"       => "java.util.Date"
      case "uuid"           => "java.util.UUID"
      case dictPattern(k,v) => s"java.util.Map<${dataTypesForJava(DataType(k))},${dataTypesForJava(DataType(v))}>"
      case listPattern(e)   => s"java.util.List<${dataTypesForJava(DataType(e))}>"
      case other            =>  other
    }
  }
}
