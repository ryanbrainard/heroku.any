package com.heroku.any.schema.rich

import com.heroku.any.TextUtils

case class Schema(filename: String,
                  resources: Iterable[Resource])

case class Resource(name: String,
                    actions: Seq[Action],
                    attributes: Seq[Attribute],
                    description: String,
                    serialization: Option[Seq[String]]) {
  def className = TextUtils.capitalCamelCase(name)
}

case class Attribute(name: String,
                     description: String,
                     dataType: DataType) {
  def fieldName = TextUtils.camelCase(name)
}

case class Action(name: String,
                  method: String,
                  path: String,
                  status: String)

case class DataType(raw: String)