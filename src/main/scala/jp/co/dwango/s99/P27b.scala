package jp.co.dwango.s99

import Util.flatMap
import Util.map

import P04.length
import P26.groupInto

object P27b {
  def group[T](setting: List[Int], list: List[T]): List[List[List[T]]] = {
    def group_(setting: List[Int],
               n: Int,
               list: List[T]): List[List[List[T]]] = {
      setting match {
        case Nil => List(Nil)
        case x :: xs =>
          flatMap(groupInto(n, x, list)) {
            case (s, r) => map(group_(xs, n - x, r))(k => k.::(s))
          }
      }
    }
    group_(setting, length(list), list)
  }
}
