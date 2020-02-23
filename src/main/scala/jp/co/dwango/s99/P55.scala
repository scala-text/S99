package jp.co.dwango.s99
import jp.co.dwango.s99.binary_trees._

object P55 {
  object Tree {
    def cBalanced[T](count: Int, value: T): List[Tree[T]] = {
      require(count >= 0)
      if (count == 0) {
        List(End)
      } else if (count % 2 == 0) {
        val ls = cBalanced((count - 1) / 2, value)
        val rs = cBalanced((count - 1) / 2 + 1, value)
        ls.flatMap { l =>
          rs.flatMap { r => List(new Node(value, l, r), new Node(value, r, l)) }
        }
      } else {
        val childrenList = cBalanced(count / 2, value)
        for {
          l <- childrenList
          r <- childrenList
        } yield new Node(value, l, r)
      }
    }
  }
}
