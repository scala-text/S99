package s99

object P22 {
  def range(from: Int, to: Int): List[Int] = {
    @scala.annotation.tailrec
    def loop(curr: Int, reversed: List[Int]): List[Int] = {
      if (curr == to) (curr :: reversed).reverse
      else if (curr < to) loop(curr + 1, curr :: reversed)
      else sys.error("")
    }
    loop(from, List())
  }
}
