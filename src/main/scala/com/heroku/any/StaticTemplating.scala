package com.heroku.any

import java.io.File

trait StaticTemplating {
  self: Generator =>

  def copyTemplates(dest: File) {
    copyTemplates(new File(s"src/main/templates/$name"), dest)
  }

  def copyTemplates(src: File, dest: File) {
    copyDir(src, dest)
  }

  private def copyDir(src: File, dest: File, rel: String = "") {
    if (src.isDirectory) {
      src.list().foreach { child =>
        copyDir(new File(src, child), dest, s"$rel${File.separator}$child")
      }
    } else {
      copyFile(src, new File(dest, rel))
    }
  }

  private def copyFile(src: File, dest: File) {
    dest.getParentFile.mkdirs()
    import java.io.{FileInputStream,FileOutputStream}
    new FileOutputStream(dest).getChannel.transferFrom(new FileInputStream(src).getChannel, 0, Long.MaxValue)
  }
}
