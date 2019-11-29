package jp.co.dwango.s99

import binary_trees._
import P62._
import org.scalatest.diagrams.Diagrams
import org.scalatest.funspec.AnyFunSpec

class P62Spec extends AnyFunSpec with Diagrams {
  describe("P62") {
    it("collect value of internal nodes") {
      assert(
        Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList == List(
          'a',
          'c'
        )
      )
    }
  }
}
