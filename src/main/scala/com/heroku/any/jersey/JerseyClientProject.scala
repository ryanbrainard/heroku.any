package com.heroku.any.jersey

import java.io.File
import com.heroku.any.{StaticTemplating, Generator}

trait JerseyClientProject extends StaticTemplating {
  self: Generator =>

  val packagePath = "/com/heroku/api"
  val packageName = "com.heroku.api"
  val staticTemplates = new File("src/main/templates/jersey-client")
}
