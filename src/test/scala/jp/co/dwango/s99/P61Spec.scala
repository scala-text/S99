package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}
import binary_trees._
import P61._

class P61Spec extends FunSpec with DiagrammedAssertions {
  describe("P61"){
    it("count leaves correctly"){
      assert(Node("a",Node("a"),End).leafCount == 1)
      assert(Node('a',
        Node('b', Node('d'), Node('e')),
        Node('c', End, Node('f', Node('g'), End))).leafCount == 3)
    }
  }
}
