package com.heroku.any

import com.heroku.any.schema.Schema

trait Generator {
  def generate(schema: Schema)
}