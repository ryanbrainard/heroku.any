package com.heroku.any.schema.rich

import com.heroku.any.TextUtils

case class Schema(filename: String,
                  resources: Seq[Resource]) {
  def resourcesSecondClass = {
    resources.flatMap { resource =>
      resource.attributes.filter(_.name.contains(":")).map { attribute =>
        attribute.name.split(":")
      }
    }.collect { case Array(a,b) => (a,b) }.foldLeft(Map[String, Set[String]]()) { (agg,t) =>
        agg + (t._1.capitalize -> agg.get(t._1).map(_ + t._2).getOrElse(Set(t._2)))
      }.filter(r => resources.exists(_.name == r._1)).map { r =>
        Resource(r._1, Seq(), r._2.map(a => Attribute(a, "", DataType("string"))).toSeq, "", r._2.toSeq)
      }
  }
}

case class Resource(name: String,
                    actions: Seq[Action],
                    attributes: Seq[Attribute],
                    description: String,
                    serialization: Seq[String]) {
  def resourceClassName = TextUtils.capitalize(TextUtils.camelCase(name))
  def modelClassName = TextUtils.singularize(resourceClassName)
  def actionsClassName = resourceClassName + "Actions"
  def serializableAttributes = attributes.filter { a =>
    !a.name.contains(":") && serialization.contains(a.name)
  }
}

case class Attribute(name: String,
                     description: String,
                     dataType: DataType) {
  def fieldName = name
  def paramName = TextUtils.camelCase(name)
}

case class Action(name: String,
                  httpMethod: String,
                  path: String,
                  status: String,
                  requiredAttributes: Seq[String],
                  optionalAttributes: Seq[String]) {
  def methodName = TextUtils.camelCase(name)
  def returnable = httpMethod != "DELETE"
  def actionClassName(resource: Resource) =
    TextUtils.capitalize(TextUtils.camelCase(resource.name)) + TextUtils.capitalize(methodName) + "Action"
}

case class DataType(raw: String)