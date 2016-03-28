package jp.co.dwango.s99

import P04.length
import P23.randomSelect

object P25 {
  def randomPermute[T](list: List[T]): List[T] = randomSelect(length(list), list)
}
