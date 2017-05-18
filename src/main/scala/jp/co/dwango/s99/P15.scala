package jp.co.dwango.s99

import Util.flatMap
import Util.copyN

object P15 {
  def duplicateN[T](n: Int, list: List[T]): List[T] = {
    flatMap(list) { case x => copyN(x, n) }
  }
}
