package s99

import binary_trees._
import P62._

import org.scalatest.funspec.AnyFunSpec

class P62Spec extends AnyFunSpec {
  describe("P62") {
    it("collect value of internal nodes") {
      assert(
        Node(
          'a',
          Node('b'),
          Node('c', Node('d'), Node('e'))
        ).internalList == List(
          'a',
          'c'
        )
      )
    }
  }
}
