package com.heroku.any.schema.rich

import com.heroku.any.TextUtils

case class Schema(filename: String,
                  resources: Iterable[Resource])

case class Resource(name: String,
                    actions: Seq[Action],
                    attributes: Seq[Attribute],
                    description: String,
                    serialization: Option[Seq[String]]) {
  def resourceClassName = TextUtils.capitalize(TextUtils.camelCase(name))
  def modelClassName = TextUtils.singularize(resourceClassName)
  def actionsClassName = resourceClassName + "Actions"
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
  def actionClassName(resource: Resource) =
    TextUtils.capitalize(TextUtils.camelCase(resource.name)) + TextUtils.capitalize(methodName) + "Action"
}

case class DataType(raw: String)