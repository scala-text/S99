package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}
import binary_trees._
import P62._

class P62Spec extends FunSpec with DiagrammedAssertions {
  describe("P62"){
    it("collect value of internal nodes"){
      assert(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList == List('a','c'))
    }
  }
}
