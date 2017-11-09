package jp.co.dwango.s99
import binary_trees._

object P62 {
  implicit class RichTree[T](tree: Tree[T]) {
    def internalList: List[T] = tree match {
      case Node(_, End, End)    => Nil
      case End                  => Nil
      case Node(v, left, right) => v :: left.internalList ++ right.internalList
    }
  }
}
