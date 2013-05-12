package com.heroku.any.schema.json

import com.heroku.any.schema.rich.Richable

case class Schema(resources: Map[String,Resource]) extends Richable[com.heroku.any.schema.rich.Schema] {
  def toRich(name: String) = new com.heroku.any.schema.rich.Schema(name, Richable.fromMap(resources))
}

case class Resource(actions: Map[String, Action],
                    attributes: Map[String, Attribute],
                    description: String,
                    serialization: Option[Seq[String]]) extends Richable[com.heroku.any.schema.rich.Resource] {
  def toRich(name: String) = new com.heroku.any.schema.rich.Resource(
      name,
      Richable.fromMap(actions),
      Richable.fromMap(attributes),
      description,
      serialization
  )
}

case class Attribute(description: String,
                     `type`: String) extends Richable[com.heroku.any.schema.rich.Attribute] {
  def toRich(name: String) = new com.heroku.any.schema.rich.Attribute(name, description, new com.heroku.any.schema.rich.DataType(`type`))
}

case class Action(method: String,
                  path: String,
                  status: String) extends Richable[com.heroku.any.schema.rich.Action] {
  def toRich(name: String) = new com.heroku.any.schema.rich.Action(name, method, path, status)
}