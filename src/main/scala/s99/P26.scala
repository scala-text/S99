package s99

import Util.append
import Util.map

import P04.length

object P26 {
  def groupInto[T](n: Int, k: Int, list: List[T]): List[(List[T], List[T])] =
    list match {
      case _ if k == n      => List((list, Nil))
      case _ if k == 0      => List((Nil, list))
      case x :: xs if k > 0 =>
        append(
          map(groupInto(n - 1, k - 1, xs)) { a => (x :: a._1, a._2) },
          map(groupInto(n - 1, k, xs)) { a => (a._1, x :: a._2) }
        )
      case _ => sys.error("")
    }
  def combinations[T: Ordering](k: Int, list: List[T]): List[List[T]] = {
    map(groupInto(length(list), k, list))(_._1).map(_.sorted).distinct
  }
}
