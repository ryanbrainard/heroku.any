package com.heroku.any.jersey

import com.heroku.any.{TextUtils, ScalateTemplating, StaticTemplating, Generator}
import com.heroku.any.schema.rich.{DataType, Schema}
import java.io.File

class JerseyClientScalateGenerator extends Generator with JerseyClientProject with ScalateTemplating {

  def name = "jersey-client-scalate"

  def generate(schema: Schema, root: File) {
    val dest = new File(root, s"/src/main/java/$packagePath")

    copyStaticTemplates(staticTemplates, dest)

    val models = schema.resources.map { r =>
      val file = new File(dest, s"${r.name}.java")

      val fields = r.serializableAttributes.map  { a =>
        Field(
          a.name,
          TextUtils.camelCase(a.name),
          TextUtils.camelCase(a.name).capitalize,
          dataTypesForJava(a.dataType),
          dataTypesForJava(a.dataType).forall(_.isLower),
          a.description)
      }

      val model = Model(
        r.name,
        Field(
          r.name,
          TextUtils.camelCase(r.name).toLowerCase,
          TextUtils.camelCase(r.name).capitalize,
          r.name,
          primitive = false,
          r.description
        ),
        r.hashCode.toString,
        fields
      )

      (file -> model)
    }.toMap

    renderTemplates("model.ssp", models)
  }

  private def dataTypesForJava(dataType: DataType):String = {
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

case class Model(
  name: String,
  asField: Field,
  serialVersionUID: String,
  fields: Seq[Field]
)

case class Field(
  name: String,
  camelCase: String,
  camelCaps: String,
  dataType: String,
  primitive: Boolean,
  doc: String
)