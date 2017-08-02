import nlp.OpenNlpTextAnalyzer

/**
  * @author
  */
object Main extends App {

  val regex = "[A-Za-z]*".r.pattern

  val AllDigits = "[0-9.]+".r.pattern

  println(regex.matcher("hello").matches())
  println(AllDigits.matcher("123").matches())
  println(AllDigits.matcher("123.44").matches())

  val nlp = new OpenNlpTextAnalyzer()

}
