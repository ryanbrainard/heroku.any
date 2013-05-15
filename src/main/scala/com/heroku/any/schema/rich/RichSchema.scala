package com.heroku.any.schema.rich

import com.heroku.any.TextUtils

case class Schema(filename: String,
                  resources: Seq[Resource]) {
  def resourcesSecondClass = resources.flatMap { resource =>
    resource.attributes.filter(_.name.contains(":")).map { attribute =>
      val Array (obj,field) = attribute.name.split(":")
      (obj,Attribute(field, field, attribute.dataType))
    }
  }.foldLeft(Map[String, Set[Attribute]]()) { (agg,a) =>
      agg + (a._1.capitalize -> agg.get(a._1).map(_ + a._2).getOrElse(Set(a._2)))
  }.filterNot(r => resources.exists(resource => resource.modelClassName == r._1)).map { r =>
    Resource(r._1, Seq(), r._2.toSeq, "", r._2.map(_.name).toSeq)
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
    serialization.contains(a.name)
  }.map { a =>
    if (a.name.contains(":")) {
      val Array (obj,field) = a.name.split(":")
      Attribute(obj, obj, DataType(obj.capitalize))
    } else {
      a
    }
  }.toSet.toSeq
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