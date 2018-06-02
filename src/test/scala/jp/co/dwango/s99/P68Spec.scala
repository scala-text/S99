package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}
import P68._
import binary_trees._

class P68Spec extends FunSpec with DiagrammedAssertions {
  describe("P68") {
    it("do pre-order traversal") {
      assert(
        Tree.string2Tree("a(b(d,e),c(,f(g,)))").preorder ==
          List('a', 'b', 'd', 'e', 'c', 'f', 'g')
      )
    }
    it("do in-order traversal") {
      assert(
        Tree.string2Tree("a(b(d,e),c(,f(g,)))").inorder ==
          List('d', 'b', 'e', 'a', 'c', 'g', 'f')
      )
    }
  }
}
