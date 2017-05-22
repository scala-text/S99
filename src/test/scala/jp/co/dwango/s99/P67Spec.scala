package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}
import P67._
import binary_trees._

class P67Spec extends FunSpec with DiagrammedAssertions{
  describe("P67"){
    it("represents another string representation"){
      assert(Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))).toString2 == "a(b(d,e),c(,f(g,)))")
    }
    it("build Node from string"){
      assert(Tree.fromString("a(b(d,e),c(,f(g,)))") == Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))))
    }
  }
}
