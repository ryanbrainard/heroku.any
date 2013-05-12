package com.heroku.any.schema.rich

import com.heroku.any.TextUtils

case class Schema(filename: String,
                  resources: Iterable[Resource])

case class Resource(name: String,
                    actions: Seq[Action],
                    attributes: Seq[Attribute],
                    description: String,
                    serialization: Option[Seq[String]]) {
  private def capCamelName = TextUtils.capitalize(TextUtils.camelCase(name))
  def modelClassName = TextUtils.singularize(capCamelName)
  def actionsClassName = capCamelName + "Actions"
}

case class Attribute(name: String,
                     description: String,
                     dataType: DataType) {
  def fieldName = TextUtils.camelCase(name)
}

case class Action(name: String,
                  httpMethod: String,
                  path: String,
                  status: String) {
  def methodName = TextUtils.camelCase(name)
  def returnable = httpMethod != "DELETE"
}

case class DataType(raw: String)