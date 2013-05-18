package com.heroku.any.schema.json

import com.heroku.any.schema.rich.Richable
import spray.json.{JsString, JsValue}

case class Schema(resources: Map[String,Resource]) extends Richable[com.heroku.any.schema.rich.Schema] {
  def toRich(name: String) = new com.heroku.any.schema.rich.Schema(
    name,
    Richable.fromMap(resources)
  )

  def addAttribute(toResource: String, name: String, description: String, dataType: String, serialized: Boolean, example: String): Schema = {
    val attrib = name -> Attribute(description, dataType, serialized, JsString(example))
    val attribs  = this.resources(toResource).attributes + attrib
    val resource = this.resources(toResource).copy(attributes = attribs)
    val resources = this.resources + (toResource -> resource)
    val schema = this.copy(resources = resources)
    schema
  }
}

case class Resource(actions: Map[String, Action],
                    attributes: Map[String, Attribute],
                    description: String) extends Richable[com.heroku.any.schema.rich.Resource] {
  def toRich(name: String) = new com.heroku.any.schema.rich.Resource(
      name,
      Richable.fromMap(actions),
      Richable.fromMap(attributes),
      description
  )
}

case class Attribute(description: String,
                     `type`: String,
                     serialized: Boolean,
                     example: JsValue) extends Richable[com.heroku.any.schema.rich.Attribute] {
  def toRich(name: String) = new com.heroku.any.schema.rich.Attribute(
    name,
    description,
    new com.heroku.any.schema.rich.DataType(`type`),
    serialized,
    example.toString()
  )
}

case class Action(method: String,
                  path: String,
                  statuses: Seq[Int],
                  attributes: Option[Requiredness]) extends Richable[com.heroku.any.schema.rich.Action] {
  def toRich(name: String) = new com.heroku.any.schema.rich.Action(
    name,
    method,
    path,
    statuses,
    attributes.flatMap(_.required).getOrElse(Seq.empty),
    attributes.flatMap(_.optional).getOrElse(Seq.empty)
  )
}

case class Requiredness(required: Option[Seq[String]],
                        optional: Option[Seq[String]])