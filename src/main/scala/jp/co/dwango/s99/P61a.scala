package jp.co.dwango.s99
import binary_trees._

object P61a {
  implicit class RichTree[T](tree: Tree[T]) {
    def leafList: List[T] = tree match {
      case Node(v, End, End) => List(v)
      case Node(_, left, right) => left.leafList ++ right.leafList
      case End => Nil
    }
  }
}
