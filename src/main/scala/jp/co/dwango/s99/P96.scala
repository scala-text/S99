package jp.co.dwango.s99

object P96 {
  /*
   <identifier> ::= <letter> <identifier_loop>?
   <identifier_loop>::=  <UNDERSCORE>? (<letter> | <digit>) <identifier_loop>?
   */

  sealed trait Result
  case class Failure(msg: String) extends Result
  case class Success(rest: String) extends Result

  class Parser(fn: String => Result) extends (String => Result) {
    override def apply(v1: String): Result = fn(v1)
    def ~(that: => Parser): Parser =
      new Parser(input =>
        this.apply(input) match {
          case f @ Failure(_) => f
          case Success(rest)  => that(rest)
      })
    def ? : Parser =
      new Parser(input =>
        this.apply(input) match {
          case Failure(_)     => Success(input)
          case s @ Success(_) => s
      })
    def |(that: => Parser): Parser =
      new Parser(input =>
        this.apply(input) match {
          case Failure(_)    => that(input)
          case Success(rest) => Success(rest)
      })
  }
  lazy val letter: Parser = new Parser(
    input => {
      if (input.length == 0) Failure("no rest input")
      else if (input.charAt(0) >= 'A' && input.charAt(0) <= 'Z' || input.charAt(
                 0) >= 'a' && input.charAt(0) <= 'z')
        Success(input.substring(1))
      else Failure(input.charAt(0) + " is not a letter")
    })
  lazy val digit: Parser = new Parser(input => {
    if (input.length == 0) Failure("no rest input")
    else if (input.charAt(0) >= '0' && input.charAt(0) <= '9')
      Success(input.substring(1))
    else Failure(input.charAt(0) + " is not a digit")
  })
  lazy val UNDERSCORE: Parser = new Parser(input => {
    if (input.length == 0) Failure("no rest input")
    else if (input.charAt(0) == '_') Success(input.substring(1))
    else Failure(input.charAt(0) + " is not a '_'")
  })
  lazy val identifierLoop
    : Parser = UNDERSCORE.? ~ (letter | digit) ~ identifierLoop.?
  lazy val identifier: Parser = letter ~ identifierLoop.?
}
