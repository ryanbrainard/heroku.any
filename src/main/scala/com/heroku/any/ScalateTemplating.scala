package com.heroku.any

import org.fusesource.scalate._
import java.io.{PrintWriter, File}
import scala.reflect.ClassTag

trait ScalateTemplating {
  self: Generator =>

  def renderTemplates[M](template: String, renditions: Map[File,M])(implicit m: ClassTag[M]) {
    val engine = new TemplateEngine
    engine.workingDirectory = new File("target/scalate")
    engine.escapeMarkup = false
    engine.bindings = m.runtimeClass.getDeclaredFields.map(f => Binding(f.getName, f.getGenericType.toString.replace("<", "[").replace(">", "]").replace("class ", ""))).toList

    renditions.foreach { case (dest: File, model: M) =>
      renderTemplate(engine, template, dest, model)
    }
  }

  private def renderTemplate[M](engine: TemplateEngine, template: String, dest: File, modelCaseClass: M)(implicit m: ClassTag[M]) {
    val attributes: Map[String, Any] = m.runtimeClass.getDeclaredFields.map { field =>
      field.setAccessible(true)
      (field.getName -> field.get(modelCaseClass))
    }.toMap

    dest.getParentFile.mkdirs()
    val writer = new PrintWriter(dest)
    engine.layout(new File(s"src/main/templates/$name/scalate/$template").getAbsolutePath, writer, attributes)
    writer.close()
  }
}