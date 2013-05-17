package com.heroku.any

import spray.json.RootJsonFormat
import spray.json.DefaultJsonProtocol._
import com.heroku.any.schema.json._
import com.heroku.any.schema.json.Schema
import com.heroku.any.schema.json.Requiredness
import com.heroku.any.schema.json.Resource
import com.heroku.any.schema.json.Attribute
import com.heroku.any.schema.json.Action

object HerokuApiProtocol {
  implicit val RequirednessFormat: RootJsonFormat[Requiredness] = jsonFormat2(Requiredness)
  implicit val AttributeFormat: RootJsonFormat[Attribute] = jsonFormat4(Attribute)
  implicit val ActionFormat: RootJsonFormat[Action] = jsonFormat4(Action)
  implicit val ResourceFormat: RootJsonFormat[Resource] = jsonFormat3(Resource)
  implicit val SchemaFormat: RootJsonFormat[Schema] = jsonFormat1(Schema)
}
