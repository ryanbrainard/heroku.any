package com.heroku.any.jersey

import com.heroku.any.{TextUtils, ScalateTemplating, Generator}
import com.heroku.any.schema.rich.Schema
import java.io.File

class JerseyClientScalateGenerator extends Generator with JerseyClientFacet with ScalateTemplating {

  def name = "jersey-client-scalate"

  def generate(schema: Schema, root: File) {
    copyStaticTemplates(staticTemplates, root)

    val dest = new File(root, s"/src/main/java/$packagePath")
    val models = schema.resources.map { r =>
      val file = new File(dest, s"${r.name}.java")

      val fields = r.serializableAttributes.map  { a =>
        Field(
          a.name,
          TextUtils.camelCase(a.name),
          TextUtils.camelCase(a.name).capitalize,
          dataTypeToString(a.dataType),
          dataTypeToString(a.dataType).forall(_.isLower),
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