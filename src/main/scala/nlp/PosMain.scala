package nlp

/**
  */
object PosMain extends App {

  val input = args.mkString(" ")

  println(new OpenNlpTextAnalyzer().tagPos(input))

}
