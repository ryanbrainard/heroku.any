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

  test("capitalCamelCasing") {
    assert(TextUtils.capitalCamelCase("fried_chicken_and_waffles") === "FriedChickenAndWaffles")
    assert(TextUtils.capitalCamelCase("fried")                     === "Fried")
    assert(TextUtils.capitalCamelCase("")                          === "")
    assert(TextUtils.capitalCamelCase(null)                        === null)
  }
}