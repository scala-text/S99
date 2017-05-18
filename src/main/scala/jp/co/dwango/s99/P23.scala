package jp.co.dwango.s99

import P04.length
import P20.removeAt

object P23 {
  def randomSelect[T](n: Int, list: List[T]): List[T] = {
    def randomSelect1(n: Int, len: Int, list: List[T]): List[T] = {
      if (n == 0) List[T]()
      else if (n > 0) {
        val (rest, e) = removeAt((Math.random * len).toInt, list)
        e :: randomSelect1(n - 1, len - 1, rest)
      } else sys.error("")
    }
    val len = length(list)
    if (n <= len) randomSelect1(n, len, list) else sys.error("")
  }
}
