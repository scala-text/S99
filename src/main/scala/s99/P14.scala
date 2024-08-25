package s99

import Util.flatMap

object P14 {
  def duplicate[T](list: List[T]): List[T] = {
    flatMap(list) { case x => List(x, x) }
  }
}
