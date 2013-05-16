package com.heroku.any

import com.heroku.any.schema.rich.Schema
import java.io.File

class NoOpGenerator extends Generator {
  def name = "noop"

  def generate(schema: Schema, root: File) { }
}
