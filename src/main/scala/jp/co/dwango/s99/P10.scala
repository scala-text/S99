package jp.co.dwango.s99

import P04.length
import P05.reverse
import P09.pack

object P10 {
  def encode[T](list: List[T]): List[(Int, T)] = {
    def go(list: List[List[T]], result: List[(Int, T)]): List[(Int, T)] =
      list match {
        case x :: xs => go(xs, (length(x), x.head) :: result)
        case Nil     => result
      }
    reverse(go(pack(list), Nil))
  }
}
