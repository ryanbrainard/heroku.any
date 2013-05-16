package com.heroku.any

import org.scalatest.FunSuite
import java.io.File
import scala.sys.process.{ProcessLogger, Process}

class GoldFileSuite extends FunSuite {

  test("jersey-client") {
    val docJson = "src/test/goldfiles/doc.json"
    val expectedOutputDir = "src/test/goldfiles/jersey-client"
    val actualOutputDir = File.createTempFile("heroku-any-goldfile-test-jersey-client", "")
    actualOutputDir.delete()
    actualOutputDir.mkdir()

    Generate.main(s"-f $docJson -o ${actualOutputDir.getAbsolutePath} -g jersey-client".split(" "))

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