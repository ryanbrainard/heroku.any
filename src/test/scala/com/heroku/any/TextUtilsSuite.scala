package com.heroku.any

import org.scalatest.FunSuite

class TextUtilsSuite extends FunSuite {

  test("capitalization") {
    assert(TextUtils.capitalize("cat") === "Cat")
    assert(TextUtils.capitalize("c")   === "C")
    assert(TextUtils.capitalize("")    === "")
    assert(TextUtils.capitalize(null)  === null)
  }

  test("camelCasing") {
    assert(TextUtils.camelCase("fried_chicken_and_waffles") === "friedChickenAndWaffles")
    assert(TextUtils.camelCase("fried")                     === "fried")
    assert(TextUtils.camelCase("")                          === "")
    assert(TextUtils.camelCase(null)                        === null)
  }

  test("singularize") {
    assert(TextUtils.singularize("waffles")  === "waffle")
    assert(TextUtils.singularize("glasses")  === "glass")
    assert(TextUtils.singularize("chickens") === "chicken")
    assert(TextUtils.singularize("children") === "children") // todo: handle special cases
    assert(TextUtils.singularize("")         === "")
    assert(TextUtils.singularize(null)       === null)
  }
}