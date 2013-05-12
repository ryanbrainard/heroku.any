package com.heroku.any.schema.rich

trait Richable[R] {
  def toRich(name: String): R
}

object Richable {
  def fromMap[R](m: Map[String, Richable[R]]): Seq[R] = {
    m.map { case (name: String, r: Richable[R]) =>
      r.toRich(name)
    }.toSeq
  }
}