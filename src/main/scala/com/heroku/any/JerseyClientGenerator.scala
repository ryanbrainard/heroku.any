package com.heroku.any

import com.heroku.any.schema.rich._
import java.io.{File, FileOutputStream, PrintWriter}
import com.squareup.java.JavaWriter
import java.lang.reflect.Modifier._

class JerseyClientGenerator extends Generator {

  val packagePath = "/com/heroku/api"
  val packageName = "com.heroku.api"

  val name = "jersey-client"

  def generate(schema: Schema, root: File) {
    val srcRoot = new File(root, s"/src/main/java/$packagePath")
    srcRoot.mkdirs()
    copyStaticFiles(root)
    (schema.resources ++ schema.resourcesSecondClass).foreach { resource: Resource =>
      if (resource.isModel) generateModel(resource, srcRoot)
      resource.actions.foreach { action =>
        generateResourceActionClass(resource, action, srcRoot)
      }
    }
  }

  private def copyStaticFiles(root: File) {
    copyDir(new File(s"src/main/templates/$name"), root)
  }

  private def copyDir(src: File, dest: File, rel: String = "") {
    if (src.isDirectory) {
      src.list().foreach { child =>
        copyDir(new File(src, child), dest, s"$rel${File.separator}$child")
      }
    } else {
      copyFile(src, new File(dest, rel))
    }
  }

  private def copyFile(src: File, dest: File) {
    dest.getParentFile.mkdirs()
    import java.io.{FileInputStream,FileOutputStream}
    new FileOutputStream(dest).getChannel.transferFrom(new FileInputStream(src).getChannel, 0, Long.MaxValue)
  }

  private def generateResourceActionClass(resource: Resource, action: Action, srcRoot: File) {
    val requestAttributes =  action.requestEntity(resource) match { case AttributeRequestEntity(attribute: Attribute) => Seq(attribute); case _ => Seq() }
    val requiredAttributes = action.pathAttributes.toSeq ++ resource.attributes.filter(a => action.requiredAttributes.contains(a.name)) ++ requestAttributes
    val optionalAttributes = resource.attributes.filter(a => action.optionalAttributes.contains(a.name))
    val topLevelAttributes = (requiredAttributes ++ optionalAttributes).map(_.massaged).toSet
    val className = action.actionClassName(resource)
    val out = new PrintWriter(new FileOutputStream(s"$srcRoot/$className.java"))
    val writer = new JavaWriter(out)

    // header
    writer
      .emitPackage(packageName)
      .emitAnnotation(classOf[org.codehaus.jackson.map.annotate.JsonSerialize])
      .beginType(packageName + "." + className, "class", PUBLIC | FINAL, null, s"Action<${dataTypesForJava(action.responseDataType(resource))}>")
      .emitEmptyLine()

    topLevelAttributes.foreach { a =>
      if (action.pathAttributes.contains(a)) writer.emitAnnotation(classOf[org.codehaus.jackson.annotate.JsonIgnore])
      writer.emitField(a.dataType, a.fieldName, PRIVATE)
    }

    writer
      .emitEmptyLine()
      .beginMethod(null, className, PUBLIC, requiredAttributes.flatMap(a => Seq[String](a.dataType, a.paramName)):_*)
      requiredAttributes.foreach(a => writer.emitStatement(s"this.${a.fieldName} = ${a.paramName}"))
      writer
        .endMethod()
        .emitEmptyLine()

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

    val requestEntity = action.requestEntity(resource) match {
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
      .beginMethod(s"com.sun.jersey.api.client.GenericType<${dataTypesForJava(action.responseDataType(resource))}>", "responseType", PUBLIC)
      .emitStatement(s"return new com.sun.jersey.api.client.GenericType<${dataTypesForJava(action.responseDataType(resource))}>(){}")
      .endMethod()

    topLevelAttributes.foreach { a =>
      writer
        .emitEmptyLine()
        .beginMethod(a.dataType, s"get${TextUtils.capitalize(a.paramName)}", PUBLIC)
        .emitStatement(s"return this.${a.fieldName}")
        .endMethod()
    }

    optionalAttributes.map(_.massaged).toSet.foreach { a: Attribute =>
      writer
        .emitEmptyLine()
        .emitJavadoc(s"Set ${a.description}")
        .beginMethod(className, s"set${TextUtils.capitalize(a.paramName)}", PUBLIC, a.dataType, a.paramName)
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
      .beginType(packageName + "." + dataTypesForJava(resource.modelClassName), "class", PUBLIC)

    // fields
    resource.serializableAttributes.foreach { attribute: Attribute =>
      writer
        .emitEmptyLine()
        .emitJavadoc(TextUtils.capitalize(attribute.description))
        .emitAnnotation(classOf[org.codehaus.jackson.annotate.JsonProperty])
        .emitField(attribute.dataType, attribute.fieldName, PRIVATE)
    }

    writer.emitEmptyLine()

    if (!resource.serializableAttributes.isEmpty) {
      // empty constructor
      writer
        .emitJavadoc(s"Construct empty ${resource.name}")
        .beginMethod(null, resource.modelClassName, PUBLIC)
        .endMethod()
        .emitEmptyLine()
    }

    // fully-qualified constructor
    writer.beginMethod(null, resource.modelClassName, PUBLIC, resource.serializableAttributes.map { attribute: Attribute =>
        Seq[String](attribute.dataType, attribute.fieldName)
    }.flatten.toSeq:_*)
    resource.serializableAttributes.foreach { attribute: Attribute =>
      writer.emitStatement(s"this.${attribute.fieldName} = ${attribute.fieldName}")
    }
    writer.endMethod().emitEmptyLine()

    // getters and setters
    resource.serializableAttributes.foreach { attribute: Attribute =>
      writer
        .emitJavadoc(s"Get ${attribute.description}")
        .beginMethod(attribute.dataType, s"get${TextUtils.capitalize(attribute.paramName)}", PUBLIC)
        .emitStatement(s"return this.${attribute.fieldName}")
        .endMethod()
        .emitEmptyLine()
    }

    writer.endType()
    out.flush()
    out.close()
  }

  private implicit def dataTypesForJava(dataType: DataType):String = dataType.raw match {
    case "string"      => "String"
    case "number"      => "Number"
    case "datetime"    => "java.util.Date"
    case "uuid"        => "java.util.UUID"
    case "dictionary"  => "java.util.Map"
    case list if list.matches("""list\[\w+\]""")  => "java.util.List"
    case other         =>  other
  }
}
