package com.heroku.any

object TextUtils {
  def capitalize(s: String): String = {
    if (s == null || s.isEmpty) s
    else if (s.length == 1) s.toUpperCase
    else s.charAt(0).toUpper + s.substring(1)
  }

  def camelCase(s: String): String = {
    if (s == null) s
    else {
      val split = s.split('_')
      split.head + split.tail.map(capitalize).mkString
    }
  }

  def capitalCamelCase(s: String): String = {
    capitalize(camelCase(s))
  }
}