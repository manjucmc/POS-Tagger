import java.io.{FileInputStream, FileOutputStream}

name := "nlp-pos"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= {
  Seq(
    "org.apache.opennlp" % "opennlp-tools" % "1.7.2",
    "org.scala-lang.modules" %% "scala-xml" % "1.0.6" % "test"
  )
}

mainClass in assembly := Some("nlp.PosMain")

assembly ~= (file => {
  new FileOutputStream(new File("pos.jar"))
    .getChannel.transferFrom(new FileInputStream(file).getChannel, 0, Long.MaxValue)
  file
})

