package jp.co.dwango.s99

object P09 {
  def pack[T](list: List[T]): List[List[T]] =
    list.foldRight(Nil: List[List[T]]) { (e, ls) =>
      ls match {
        case (x @ `e` :: _) :: xs => (e :: x) :: xs
        case _                    => List(e) :: ls
      }
    }
}
