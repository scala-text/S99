package s99

import s99.binary_trees._

object P68 {
  implicit class RichTree[T](tree: Tree[T]) {
    def preorder: List[T] =
      tree match {
        case Node(v, l, r) =>
          List(v) ++ l.preorder ++ r.preorder
        case End =>
          Nil
      }
    def inorder: List[T] =
      tree match {
        case Node(v, l, r) =>
          l.inorder ++ List(v) ++ r.inorder
        case End =>
          Nil
      }
  }
  object Tree {
    def string2Tree(str: String): Node[Char] = P67.Tree.fromString(str)
  }
}
