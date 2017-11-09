package jp.co.dwango.s99

import scala.annotation.tailrec

object P05 {
  def reverse[T](list: List[T]): List[T] = {
    @tailrec
    def go(rem: List[T], acc: List[T]): List[T] = rem match {
      case Nil     => acc
      case x :: xs => go(xs, x :: acc)
    }
    go(list, Nil)
  }
}
