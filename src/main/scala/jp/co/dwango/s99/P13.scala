package jp.co.dwango.s99

object P13 {
  def encodeDirect[T](list: List[T]): List[(Int, T)] = {
    def encodeDirect1(pre: T, n: Int, rest: List[T]): List[(Int, T)] = {
      rest match {
        case x :: xs if pre == x => encodeDirect1(pre, n + 1, xs)
        case x :: xs             => (n, pre) :: encodeDirect1(x, 1, xs)
        case _                   => List((n, pre))
      }
    }
    list match {
      case x :: xs => encodeDirect1(x, 1, xs)
      case _       => List()
    }
  }
}
