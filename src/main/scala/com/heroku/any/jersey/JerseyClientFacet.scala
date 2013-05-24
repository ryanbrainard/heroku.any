package com.heroku.any.jersey

import java.io.File
import com.heroku.any.{JavaFacet, StaticTemplating, Generator}

trait JerseyClientFacet extends JavaFacet with StaticTemplating {
  self: Generator =>

  val packagePath = "/com/heroku/api"
  val packageName = "com.heroku.api"
  val staticTemplates = new File("src/main/templates/jersey-client")
}
