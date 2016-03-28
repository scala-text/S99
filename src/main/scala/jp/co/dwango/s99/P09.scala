package jp.co.dwango.s99

object P09 {
  def pack[T](list: List[T]): List[List[T]] = {
    def pack1(pre: List[T], rest: List[T]): List[List[T]] = rest match {
      case x::xs if pre.head == x => pack1(x::pre, xs)
      case x::xs => pre::pack1(List(x), xs)
      case Nil => pre::Nil
    }
    list match {
      case x::xs => pack1(List(x), xs)
      case Nil => Nil
    }
  }
}
