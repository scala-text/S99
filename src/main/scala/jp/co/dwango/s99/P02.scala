package jp.co.dwango.s99

object P02 {
  def penultimate[T](list: List[T]): T = list match {
    case x :: _ :: Nil => x
    case _ :: y :: xs  => penultimate(y :: xs)
    case _ =>
      sys.error("penultimate is not defined for one or less elements list")
  }
}
