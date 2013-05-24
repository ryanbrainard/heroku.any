package com.heroku.any

import com.heroku.any.schema.rich.DataType
import scala.language.implicitConversions

trait JavaFacet {

  self: Generator =>

  implicit def dataTypeToString(dataType: DataType):String = {
    val listPattern = """list\[(\w+)\]""".r
    val dictPattern = """dictionary\[(\w+),(\w+)\]""".r

    dataType.raw match {
      case "string"         => "String"
      case "number"         => "Number"
      case "datetime"       => "java.util.Date"
      case "uuid"           => "java.util.UUID"
      case dictPattern(k,v) => s"java.util.Map<${dataTypeToString(DataType(k))},${dataTypeToString(DataType(v))}>"
      case listPattern(e)   => s"java.util.List<${dataTypeToString(DataType(e))}>"
      case other            =>  other
    }
  }

}
