package jp.co.dwango.s99

import Util.flatMap
import Util.copyN

object P12 {
  def decode[T](encoded: List[(Int, T)]): List[T] = {
    flatMap(encoded){ case (n, e) => copyN(e, n) }
  }
}
