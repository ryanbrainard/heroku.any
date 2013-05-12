package com.heroku.any

import spray.json.RootJsonFormat
import spray.json.DefaultJsonProtocol._
import com.heroku.any.schema.json._

object HerokuApiProtocol {
  implicit val AttributeFormat: RootJsonFormat[Attribute] = jsonFormat2(Attribute)
  implicit val ActionFormat: RootJsonFormat[Action] = jsonFormat3(Action)
  implicit val ResourceFormat: RootJsonFormat[Resource] = jsonFormat4(Resource)
  implicit val SchemaFormat: RootJsonFormat[Schema] = jsonFormat1(Schema)
}
