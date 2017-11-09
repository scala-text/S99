package jp.co.dwango.s99

object P18 {
  def slice[T](i: Int, k: Int, list: List[T]): List[T] = {
    def slice1(i: Int, k: Int, list: List[T]): List[T] = list match {
      case x :: xs if i > 0 => slice(i - 1, k - 1, xs)
      case x :: xs if k > 0 => x :: slice(0, k - 1, xs)
      case _ if i == 0      => List[T]()
      case _                => sys.error("")
    }
    if (0 <= i && i <= k) slice1(i, k, list) else sys.error("")
  }
}
