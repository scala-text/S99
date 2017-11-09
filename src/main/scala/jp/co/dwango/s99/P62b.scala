package jp.co.dwango.s99
import binary_trees._

object P62b {
  implicit class RichTree[T](tree: Tree[T]) {
    def atLevel(level: Int): List[T] =
      if (level == 1) tree match {
        case Node(v, _, _) => v :: Nil
        case End           => Nil
      } else
        tree match {
          case Node(_, left, right) =>
            left.atLevel(level - 1) ++ right.atLevel(level - 1)
          case End => Nil
        }
  }
}
