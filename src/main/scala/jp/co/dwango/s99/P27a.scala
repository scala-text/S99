package jp.co.dwango.s99

import Util.flatMap
import Util.map
import P26.groupInto

object P27a {
  def group3[T](list: List[T]): List[List[List[T]]] = {
    flatMap(groupInto(9, 2, list)) { case (s1, r) =>
      flatMap(groupInto(7, 3, r)) { case (s2, r) =>
        map(groupInto(4, 4, r)) { case (s3, r) => List(s1, s2, s3) }
      }
    }
  }
}
