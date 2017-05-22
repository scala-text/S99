package jp.co.dwango.s99
import binary_trees._

object P67 {
  implicit class RichTree[T](tree: Tree[T]) {
    def toString2: String = tree match {
      case Node(v, End, End) => v.toString
      case Node(v, left, right) => s"$v(${left.toString2},${right.toString2})"
      case End => ""
    }
  }
  object Tree {
    def fromString(str: String): Node[Char] = node(str) match {
      case Success(result, _) => result
      case Failure(msg) => throw new IllegalArgumentException(msg)
    }
  }

  sealed trait Result[+T]
  case class Failure(msg: String) extends Result[Nothing]
  case class Success[+T](result: T, rest: String) extends Result[T]

  object ~ {
    def unapply[T, U](arg: (T, U)): Option[(T, U)] = Some(arg)
  }

  class Parser[+T](fn: String => Result[T]) extends (String => Result[T]) {
    override def apply(v1: String): Result[T] = fn(v1)
    def ~[U](that: => Parser[U]): Parser[(T, U)] =
      new Parser(input =>
        this.apply(input) match {
          case f @ Failure(_) => f
          case Success(result, rest) =>
            that(rest) match {
              case f @ Failure(_) => f
              case Success(result2, rest2) => Success(result -> result2, rest2)
            }
      })
    def ? : Parser[Option[T]] =
      new Parser(input =>
        this.apply(input) match {
          case Failure(_) => Success(None, input)
          case Success(result, rest) => Success(Some(result), rest)
      })
    def |[U](that: => Parser[U]): Parser[Either[T, U]] =
      new Parser(input =>
        this.apply(input) match {
          case Failure(_) =>
            that(input) match {
              case Success(result2, rest2) => Success(Right(result2), rest2)
            }
          case Success(result, rest) => Success(Left(result), rest)
      })
    def ^^[U](fn: T => U): Parser[U] =
      new Parser(input =>
        this.apply(input) match {
          case f @ Failure(_) => f
          case Success(result, rest) => Success(fn(result), rest)
      })
  }
  lazy val letter: Parser[Char] = new Parser(input => {
    if (input.length == 0) Failure("no rest input")
    else if (input.charAt(0) >= 'A' && input.charAt(0) <= 'Z' || input.charAt(
               0) >= 'a' && input.charAt(0) <= 'z')
      Success(input.charAt(0), input.substring(1))
    else Failure(input.charAt(0) + " is not a letter")
  })
  def char(c: Char): Parser[Char] =
    new Parser(input => {
      if (input.length == 0) Failure("no rest input")
      else if (input.charAt(0) == c)
        Success(input.charAt(0), input.substring(1))
      else Failure(input.charAt(0) + " is not " + c)
    })
  lazy val tree: Parser[Tree[Char]] = (node | end) ^^ {
    case Left(v) => v
    case Right(v) => v
  }
  lazy val end: Parser[Tree[Char]] = new Parser(input => Success(End, input))
  lazy val node
    : Parser[Node[Char]] = letter ~ (char('(') ~ tree ~ char(',') ~ tree ~ char(
    ')')).? ^^ {
    case c ~ None => Node(c, End, End)
    case c ~ Some(_ ~ t1 ~ _ ~ t2 ~ _) => Node(c, t1, t2)
  }
}
