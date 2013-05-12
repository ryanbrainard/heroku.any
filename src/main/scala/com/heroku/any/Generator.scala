package com.heroku.any

import com.heroku.any.schema.rich.Schema

trait Generator {
  def generate(schema: Schema)
}