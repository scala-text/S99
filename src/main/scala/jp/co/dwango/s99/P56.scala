package jp.co.dwango.s99
import jp.co.dwango.s99.binary_trees._

object P56 {
  implicit class RichTree[T](val tree: Tree[T]) extends AnyVal {
    def isMirrorOf(another: Tree[T]): Boolean = (tree, another) match {
      case (End, End) => true
      case (End, _)   => false
      case (_, End)   => false
      case (Node(_, l1, r1), Node(_, l2, r2)) =>
        l1.isMirrorOf(r2) && r1.isMirrorOf(l2)
    }
    def isSymmetric: Boolean = tree match {
      case End           => false
      case Node(v, l, r) => l.isMirrorOf(r)
    }
  }
}
