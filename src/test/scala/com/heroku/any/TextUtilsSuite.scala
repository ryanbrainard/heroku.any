package com.heroku.any

import org.scalatest.FunSuite

class TextUtilsSuite extends FunSuite {

  test("camelCasing") {
    assert(TextUtils.camelCase("friedChickenAndWaffles")    === "friedChickenAndWaffles")
    assert(TextUtils.camelCase("Fried_chicken_and_waffles") === "friedChickenAndWaffles")
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