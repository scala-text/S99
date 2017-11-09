package jp.co.dwango.s99

object P16 {
  def drop[T](nth: Int, list: List[T]): List[T] = {
    def drop1(mth: Int, list: List[T]): List[T] = list match {
      case x :: xs if mth == 1 => drop1(nth, xs)
      case x :: xs if mth > 1  => x :: drop1(mth - 1, xs)
      case _                   => List[T]()
    }
    if (nth > 0) drop1(nth, list) else sys.error("")
  }
}
