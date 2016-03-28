package jp.co.dwango.s99

object P22 {
  def range(from: Int, to: Int): List[Int] = {
    if(from == to) List(to)
    else if(from < to) from::range(from + 1, to)
    else sys.error("")
  }
}
