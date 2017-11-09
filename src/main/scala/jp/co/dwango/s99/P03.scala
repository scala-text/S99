package jp.co.dwango.s99

object P03 {
  def nth[T](index: Int, list: List[T]): T = list match {
    case x :: _ if index == 0 => x
    case _ :: xs if index > 0 => nth(index - 1, xs)
    case _                    => sys.error("")
  }
}
