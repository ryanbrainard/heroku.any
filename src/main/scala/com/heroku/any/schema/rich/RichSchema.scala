package com.heroku.any.schema.rich

import com.heroku.any.TextUtils

case class Schema(filename: String,
                  resources: Seq[Resource]) {
  def resourcesSecondClass = resources.flatMap { resource =>
    resource.attributes.filter(_.name.contains(":")).map { attribute =>
      val Array (obj,field) = attribute.name.split(":")
      (obj.capitalize, Attribute(null, field, field, attribute.dataType, attribute.serialized, ""))
    }
  }.foldLeft(Map[String, Set[Attribute]]()) { (agg,a) =>
    agg + (a._1 -> agg.get(a._1).map(_ + a._2).getOrElse(Set(a._2)))
  }.filterNot(r => resources.exists(resource => resource.modelClassName.raw == r._1)).map { r =>
    val rich = Resource(this, r._1, Seq(), r._2.toSeq, "")
    rich.copy(attributes = rich.attributes.map(_.copy(resource = rich)))
  }
}

case class Resource(schema: Schema,
                    name: String,
                    actions: Seq[Action],
                    attributes: Seq[Attribute],
                    description: String) {
  def resourceClassName = TextUtils.capitalize(TextUtils.camelCase(name))
  def modelClassName = attributes.headOption.map(_.massaged)
    .filter(_.dataType.raw.startsWith("dictionary"))
    .map(_.dataType).getOrElse(DataType(TextUtils.singularize(resourceClassName)))
  def actionsClassName = resourceClassName + "Actions"
  def serializableAttributes = attributes.filter { a =>
    a.serialized
  }.map { a =>
    a.massaged
  }.toSet.toSeq.sortBy((a: Attribute) => a.name)
  def isModel = !attributes.headOption.exists(_.massaged.dataType.raw.startsWith("dictionary")) // TODO: de-dupe
}

case class Attribute(resource: Resource,
                     name: String,
                     description: String,
                     dataType: DataType,
                     serialized: Boolean,
                     example: String) {
  def fieldName = name
  def paramName = TextUtils.camelCase(fieldName)
  private val dictPattern = """^\"?\{([a-z-]+)\}\"?$""".r
  def massaged = if (name.contains(":")) {
    val Array (obj,field) = name.split(":")
    Attribute(resource, obj, obj, DataType(obj.capitalize), serialized, "")
  } else {
    dictPattern.findFirstMatchIn(name).map { m =>
     val dictName = m.group(1) + dictPattern.findFirstMatchIn(example).map(_.group(1).capitalize).getOrElse("") + "Pairs"
     val valueDataType = dictPattern.findFirstMatchIn(example).map(_ => dataType.raw).getOrElse("string")
      Attribute(resource, dictName, description, DataType(s"dictionary[string,$valueDataType]"), serialized, example)
    }.getOrElse(this)
  }
}

case class Action(resource: Resource,
                  name: String,
                  httpMethod: String,
                  path: String,
                  statuses: Seq[Int],
                  requiredAttributes: Seq[String],
                  optionalAttributes: Seq[String]) {
  def methodName = TextUtils.camelCase(name)
  def actionClassName =
    TextUtils.capitalize(TextUtils.camelCase(resource.name)) + TextUtils.capitalize(methodName) + "Action"
  private val pathVarPattern = """\{([a-z-]+)\}""".r
  def pathAttributes = {
    pathVarPattern.findAllIn(path).matchData.map { m =>
      Attribute(resource, TextUtils.camelCase(m.group(1)), m.group(0), DataType("string"), serialized = false, "")
    }
  }
  def requestEntity = {
    httpMethod match {
      case "GET" | "DELETE" => NullRequestEntity
      case _ =>
        resource.attributes.headOption.map(_.massaged)
          .filter(_.dataType.raw.startsWith("dictionary"))
          .map(AttributeRequestEntity(_)).getOrElse(ActionRequestEntity)
    }
  }
  def responseDataType = {
    if (name.equalsIgnoreCase("list")) {
      DataType(s"list[${resource.modelClassName.raw}]")
    } else {
      resource.modelClassName
    }
  }
}

case class DataType(raw: String)

trait RequestEntity
case object NullRequestEntity extends RequestEntity
case object ActionRequestEntity extends RequestEntity
case class AttributeRequestEntity(attribute: Attribute) extends RequestEntity