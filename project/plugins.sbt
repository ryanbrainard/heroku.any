resolvers += Classpaths.typesafeResolver

addSbtPlugin("com.typesafe.sbt" % "sbt-start-script" % "0.8.0")

resolvers += "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.4.0")