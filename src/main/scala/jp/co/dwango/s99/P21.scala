package jp.co.dwango.s99

object P21 {
  def insertAt[T](e: T, index: Int, list: List[T]): List[T] = list match {
    case x if index == 0      => e :: x
    case x :: xs if index > 0 => x :: insertAt(e, index - 1, xs)
    case _                    => sys.error("")
  }
}
