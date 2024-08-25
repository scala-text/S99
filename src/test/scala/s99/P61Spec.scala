package s99

import binary_trees._
import P61._

import org.scalatest.funspec.AnyFunSpec

class P61Spec extends AnyFunSpec {
  describe("P61") {
    it("count leaves correctly") {
      assert(Node("a", Node("a"), End).leafCount == 1)
      assert(
        Node(
          'a',
          Node('b', Node('d'), Node('e')),
          Node('c', End, Node('f', Node('g'), End))
        ).leafCount == 3
      )
    }
  }
}
