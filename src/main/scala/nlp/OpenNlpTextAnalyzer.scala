package nlp

import opennlp.tools.postag.{POSModel, POSTaggerME}
import opennlp.tools.tokenize.{TokenizerME, TokenizerModel}

import scala.util.Try

/**
  * The basic NLP facade
  */
class OpenNlpTextAnalyzer {

  private lazy val posTagger = {
    val in = getClass.getResourceAsStream("/opennlp/en-pos-maxent.bin")
    val model = new POSModel(in)
    val tagger = new POSTaggerME(model)
    Try(in.close())
    tagger
  }

  private lazy val posTokenizer = {
    val in = getClass.getResourceAsStream("/opennlp/en-token.bin")
    val model = new TokenizerModel(in)
    val tokenizer = new TokenizerME(model)
    Try(in.close())
    tokenizer
  }

  /**
    * Tag part of speech from an input text
    *
    * @param text
    * @return sequence of word and its associate tag.
    */
  def tagPos(text: String): Seq[(String, TreeBankTag)] = {
    val words = posTokenizer.tokenize(text)
    words.zip(posTagger.tag(words).map(TreeBankTags.get))
  }

}

