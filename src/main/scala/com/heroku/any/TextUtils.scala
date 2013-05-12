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
      val split = s.split(Array('_', '-', ' ', ':'))
      split.head.toLowerCase + split.tail.map(capitalize).mkString
    }
  }

  /**
   * Naive singularization without special case hanlding
   */
  def singularize(s: String): String = {
    if (s == null) s
    else if (s.endsWith("ses")) s.substring(0, s.length - 2)
    else if (s.endsWith("s"))  s.substring(0, s.length - 1)
    else s
  }
}