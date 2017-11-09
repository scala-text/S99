package jp.co.dwango.s99
import binary_trees._

object P61 {
  implicit class RichTree[T](tree: Tree[T]) {
    def leafCount: Int = tree match {
      case Node(_, End, End)    => 1
      case Node(_, left, right) => left.leafCount + right.leafCount
      case End                  => 0
    }
  }
}
