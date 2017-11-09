package jp.co.dwango.s99
import binary_trees._

import scala.annotation.tailrec

object P61a {
  implicit class RichTree[T](tree: Tree[T]) {
    def leafList: List[T] = {
      @tailrec
      def loop(queries: List[Tree[T]], acc: List[T]): List[T] = queries match {
        case Nil => acc
        case head :: tail =>
          head match {
            case End                  => loop(tail, acc)
            case Node(v, End, End)    => loop(tail, v :: acc)
            case Node(_, left, right) => loop(left :: right :: tail, acc)
          }
      }
      loop(tree :: Nil, Nil)
    }
  }
}
