package jp.co.dwango.s99

object P07 {
  def flatten(list: List[Any]): List[Any] = list match {
    case (x: List[_]) :: xs => flatten(x) ::: flatten(xs)
    case x :: xs            => x :: flatten(xs)
    case Nil                => Nil
  }
}
