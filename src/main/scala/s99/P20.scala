package s99

object P20 {
  def removeAt[T](nth: Int, list: List[T]): (List[T], T) =
    list match {
      case x :: xs if nth == 0 => (xs, x)
      case x :: xs if nth > 0 =>
        removeAt(nth - 1, xs) match { case (ys, y) => (x :: ys, y) }
      case _ => sys.error("")
    }
}
