package jp.co.dwango.s99

import P05.reverse
import Util.append

object P19 {
  def rotate[T](n: Int, list: List[T]): List[T] = {
    def rotate_+-(n: Int, visit: List[T], rest: List[T]): List[T] = n match {
      case n if n > 0 =>
        rest match {
          case Nil     => rotate_+-(n, Nil, reverse(visit))
          case x :: xs => rotate_+-(n - 1, x :: visit, xs)
        }
      case n if n < 0 =>
        visit match {
          case Nil     => rotate_+-(n, reverse(rest), Nil)
          case x :: xs => rotate_+-(n + 1, xs, x :: rest)
        }
      case 0 => append(rest, reverse(visit))
    }
    list match {
      case Nil => sys.error("")
      case _   => rotate_+-(n, Nil, list)
    }
  }

}
