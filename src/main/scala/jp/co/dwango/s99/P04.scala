package jp.co.dwango.s99

import scala.annotation.tailrec

object P04 {
  def length[T](list: List[T]): Int = {
    @tailrec
    def go(lst: List[T], n: Int): Int = lst match {
      case x :: xs => go(xs, n + 1)
      case Nil     => n
    }
    go(list, 0)
  }

}
