package com.heroku.any.schema

case class Schema(resources: Map[String,Resource])
case class Resource(actions: Map[String, Action], attributes: Map[String, Attribute], description: String, serialization: Option[Seq[String]])
case class Attribute(description: String, `type`: String)
case class Action(method: String, path: String, status: String)
