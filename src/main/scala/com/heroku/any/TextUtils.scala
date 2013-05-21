package com.heroku.any

object TextUtils {
  def camelCase(s: String): String = {
    if (s == null) s
    else {
      val split = s.split(Array('_', '-', ' ', ':'))
      if (split.length == 1) s
      else split.head.toLowerCase + split.tail.map(_.capitalize).mkString
    }
  }

  /**
   * Naive singularization without special case hanlding
   */
  def singularize(s: String): String = {
    if (s == null) s
    else if (s.endsWith("sses")) s.substring(0, s.length - 2)
    else if (s.endsWith("s"))  s.substring(0, s.length - 1)
    else s
  }
}