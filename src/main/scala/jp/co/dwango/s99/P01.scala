package jp.co.dwango.s99

object P01 {
  def last[T](list: List[T]): T = list match {
    case x :: Nil => x
    case x :: xs  => last(xs)
    case _        => sys.error("last isn't defined for empty list")
  }
}
