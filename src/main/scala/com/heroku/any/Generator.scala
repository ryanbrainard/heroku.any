package com.heroku.any

import com.heroku.any.schema.rich.Schema
import java.io.File

trait Generator {
  def name: String
  def generate(schema: Schema, root: File)
}