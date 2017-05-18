package jp.co.dwango.s99

import org.scalacheck.{Prop, Properties}
import jp.co.dwango.s99.P57.Tree
import jp.co.dwango.s99.binary_trees.Node
import jp.co.dwango.s99.binary_trees.Tree
import jp.co.dwango.s99.binary_trees.End

class P57Check extends Properties("P57") {
  private type Min = Int
  private type Max = Int
  property("Tree.fromList") = {
    def isBinarySearchTree(node: Node[Int]): Option[(Min, Max)] = node match {
      case Node(v, End, End) => Some((v, v))
      case Node(v, End, r @ Node(_, _, _)) =>
        isBinarySearchTree(r)
        for ((rmin, rmax) <- isBinarySearchTree(r)
             if v <= rmin && rmin <= rmax)
          yield (v, rmax)
      case Node(v, l @ Node(_, _, _), End) =>
        for ((lmin, lmax) <- isBinarySearchTree(l)
             if lmin <= lmax && lmax <= v)
          yield (lmin, v)
      case Node(v, l @ Node(_, _, _), r @ Node(_, _, _)) =>
        for {
          (lmin, lmax) <- isBinarySearchTree(l)
          (rmin, rmax) <- isBinarySearchTree(r)
          if lmin <= lmax && lmax <= v && v <= rmin && rmin <= rmax
        } yield (lmin, rmax)
    }
    Prop.forAll { (s: List[Int]) =>
      Tree.fromList(s) match {
        case End => true
        case node @ Node(_, _, _) =>
          isBinarySearchTree(node).isDefined
      }
    }
  }
}
