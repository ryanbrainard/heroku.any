package com.heroku.any

import org.scalatest.FunSuite
import java.io.File
import scala.sys.process.{ProcessLogger, Process}

class GoldFileSuite extends FunSuite {

  test("jersey-client") {
    assertGenerationMatchesGoldfiles("jersey-client")
  }

  def assertGenerationMatchesGoldfiles(generatorName: String) {
    val docJson = "src/test/goldfiles/doc.json"
    val expectedOutputDir = s"src/test/goldfiles/$generatorName"
    val actualOutputDir = File.createTempFile(s"heroku-any-goldfile-test-$generatorName", "")
    actualOutputDir.delete()
    actualOutputDir.mkdir()

    Generate.main(s"-f $docJson -o ${actualOutputDir.getAbsolutePath} -g $generatorName".split(" "))

    val log = StringBuilder.newBuilder
    val logger = ProcessLogger(
      (o: String) => log ++= o + "\n",
      (e: String) => log ++= e + "\n"
    )

    val diff = Process(s"diff -r $expectedOutputDir $actualOutputDir").run(logger).exitValue()
    val cleanUp = Process(s"rm -r $actualOutputDir").run(logger).exitValue()

    if (diff != 0 || cleanUp != 0) {
      fail("\n" + log.toString())
    }
  }
}