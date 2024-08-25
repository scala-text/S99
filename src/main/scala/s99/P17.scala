package s99

object P17 {
  def split[T](n: Int, list: List[T]): (List[T], List[T]) =
    list match {
      case xs if n == 0 => (List[T](), xs)
      case x :: xs if n > 0 =>
        split(n - 1, xs) match { case (a, b) => (x :: a, b) }
      case _ => sys.error("")
    }
}
