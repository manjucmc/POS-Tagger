/*
 *
 * This software is available under the MIT license.
 * Please see the LICENSE.txt file in this project.
 */
package nlp

/**
  * Penn State Tree Bank Tags
  *
  */
case class TreeBankTag(
  tag: String,
  description: String = "Unknown",
  isNoun: Boolean = false,
  isVerb: Boolean = false,
  isAdverb: Boolean = false,
  isAdjective: Boolean = false,
  isPreposition: Boolean = false
) {
  override def toString: String = s"#$tag"
}

object TreeBankTags {

  val CC: TreeBankTag = TreeBankTag("CC", "Coordinating conjunction")
  val CD: TreeBankTag = TreeBankTag("CD", "Cardinal number")
  val DT: TreeBankTag = TreeBankTag("DT", "Determiner")
  val EX: TreeBankTag = TreeBankTag("EX", "Existential there")
  val FW: TreeBankTag = TreeBankTag("FW", "Foreign word")
  val IN: TreeBankTag = TreeBankTag("IN", "Preposition or subordinating conjunction", isPreposition = true)
  val JJ: TreeBankTag = TreeBankTag("JJ", "Adjective", isAdjective = true)
  val JJR: TreeBankTag = TreeBankTag("JJR", "Adjective, comparative", isAdjective = true)
  val JJS: TreeBankTag = TreeBankTag("JJS", "Adjective, superlative", isAdjective = true)
  val LS: TreeBankTag = TreeBankTag("LS", "List item marker")
  val MD: TreeBankTag = TreeBankTag("MD", "Modal")
  val NN: TreeBankTag = TreeBankTag("NN", "Noun, singular or mass", isNoun = true)
  val NNS: TreeBankTag = TreeBankTag("NNS", "Noun, plural", isNoun = true)
  val NNP: TreeBankTag = TreeBankTag("NNP", "Proper noun, singular", isNoun = true)
  val NNPS: TreeBankTag = TreeBankTag("NNPS", "Proper noun, plural", isNoun = true)
  val PDT: TreeBankTag = TreeBankTag("PDT", "Predeterminer")
  val POS: TreeBankTag = TreeBankTag("POS", "Possessive ending")
  val PRP: TreeBankTag = TreeBankTag("PRP", "Personal pronoun")
  val PRP$: TreeBankTag = TreeBankTag("PRP$", "Possessive pronoun")
  val RB: TreeBankTag = TreeBankTag("RB", "Adverb", isAdverb = true)
  val RBR: TreeBankTag = TreeBankTag("RBR", "Adverb, comparative", isAdverb = true)
  val RBS: TreeBankTag = TreeBankTag("RBS", "Adverb, superlative", isAdverb = true)
  val RP: TreeBankTag = TreeBankTag("RP", "Particle")
  val SYM: TreeBankTag = TreeBankTag("SYM", "Symbol")
  val TO: TreeBankTag = TreeBankTag("TO", "to")
  val UH: TreeBankTag = TreeBankTag("UH", "Interjection")
  val VB: TreeBankTag = TreeBankTag("VB", "Verb, base form", isVerb = true)
  val VBD: TreeBankTag = TreeBankTag("VBD", "Verb, past tense", isVerb = true)
  val VBG: TreeBankTag = TreeBankTag("VBG", "Verb, gerund or present participle", isVerb = true)
  val VBN: TreeBankTag = TreeBankTag("VBN", "Verb, past participle", isVerb = true)
  val VBP: TreeBankTag = TreeBankTag("VBP", "Verb, non-3rd person singular present", isVerb = true)
  val VBZ: TreeBankTag = TreeBankTag("VBZ", "Verb, 3rd person singular present", isVerb = true)
  val WDT: TreeBankTag = TreeBankTag("WDT", "Wh-determiner")
  val WP: TreeBankTag = TreeBankTag("WP", "Wh-pronoun")
  val WP$: TreeBankTag = TreeBankTag("WP$", "Possessive wh-pronoun")
  val WRB: TreeBankTag = TreeBankTag("WRB", "Wh-adverb")

  private lazy val Tags = Seq(CC, CD, DT, EX, FW, IN, JJ, JJR, JJS, LS, MD, NN, NNS, NNP, NNPS,
    PDT, POS, PRP, PRP$, RB, RBR, RBS, RP, SYM, TO, UH, VB, VBD, VBG, VBN, VBP, VBZ,
    WDT, WP, WP$, WRB).foldLeft(Map.empty[String, TreeBankTag]){ (m, t) => m + (t.tag -> t) }

  val Punctuations = Set(".", "?", ",", "!", ";", "-", ":", "'", "\"", "(", ")", "[", "]", "{", "}")

  def get(tag: String): TreeBankTag = {
    Tags.getOrElse(tag, {
      if (Punctuations.contains(tag)){
        TreeBankTag(tag, "Punctuation")
      } else TreeBankTag(tag)
    })
  }

  def stripPunctuations(word: String): String = {
    val last = word.length - 1
    val p = if(Punctuations.contains(String.valueOf(word.charAt(0)))) 1 else 0
    val q = if(Punctuations.contains(String.valueOf(word.charAt(last)))) last - 1 else last
    word.substring(p, q)
  }

}
