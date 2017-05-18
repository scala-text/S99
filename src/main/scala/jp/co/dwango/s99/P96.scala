package jp.co.dwango.s99


object P96 {
  /*
   <identifier> ::= <letter> <identifier_loop>?
   <identifier_loop>::=  <UNDERSCORE>? (<letter> | <digit>) <identifier_loop>?
   */

  sealed trait Result
  case class Failure(msg:String) extends Result
  case class Success(rest:String) extends Result

  trait Parser extends (String => Result) {
    def ~(that: => Parser) = {
      val fn : String => Result = input => this.apply(input) match{
        case f@Failure(_) => f
        case Success(rest) => that(rest)
      }
      new Parser {
        override def apply(v1: String): Result = fn(v1)
      }
    }
    def ? = {
      val fn : String => Result = input => this.apply(input) match{
        case Failure(_) => Success(input)
        case s@Success(_) => s
      }
      new Parser {
        override def apply(v1: String): Result = fn(v1)
      }
    }
    def |(that: => Parser) = {
      val fn : String => Result = input => this.apply(input) match{
        case Failure(_) => that(input)
        case Success(rest) => Success(rest)
      }
      new Parser {
        override def apply(v1: String): Result = fn(v1)
      }
    }
  }
  lazy val letter = new Parser {
    override def apply(v1: String): Result = {
      if(v1.length == 0) Failure("no rest input")
      else if(v1.charAt(0) >= 'A' && v1.charAt(0) <= 'Z' || v1.charAt(0) >= 'a' && v1.charAt(0) <= 'z') Success(v1.substring(1))
      else Failure(v1.charAt(0) + " is not a letter")
    }
  }
  lazy val digit = new Parser {
    override def apply(v1: String): Result = {
      if(v1.length == 0) Failure("no rest input")
      else if(v1.charAt(0) >= '0' && v1.charAt(0) <= '9') Success(v1.substring(1))
      else Failure(v1.charAt(0) + " is not a digit")
    }
  }
  lazy val UNDERSCORE = new Parser {
    override def apply(v1: String): Result = {
      if(v1.length == 0) Failure("no rest input")
      else if(v1.charAt(0) == '_') Success(v1.substring(1))
      else Failure(v1.charAt(0) + " is not a '_'")
    }
  }
  lazy val identifierLoop : Parser = UNDERSCORE.? ~ (letter | digit) ~ identifierLoop.?
  lazy val identifier = letter ~ identifierLoop.?
}
