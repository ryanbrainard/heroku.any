package com.heroku.any

import com.heroku.any.schema._
import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat

object HerokuApiProtocol {
  implicit val AttributeFormat: RootJsonFormat[Attribute] = jsonFormat2(Attribute)
  implicit val ActionFormat: RootJsonFormat[Action] = jsonFormat3(Action)
  implicit val ResourceFormat: RootJsonFormat[Resource] = jsonFormat4(Resource)
  implicit val SchemaFormat: RootJsonFormat[Schema] = jsonFormat1(Schema)
}
