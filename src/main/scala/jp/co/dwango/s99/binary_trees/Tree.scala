package jp.co.dwango.s99.binary_trees

sealed abstract class Tree[+T]
case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString =
    "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
}
case object End extends Tree[Nothing] {
  override def toString = "."
}
object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
