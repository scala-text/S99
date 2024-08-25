package s99

import binary_trees._
import P61a._

import org.scalatest.funspec.AnyFunSpec

class P61aSpec extends AnyFunSpec {
  describe("P61a") {
    it("collect value of leaves") {
      assert(
        Node(
          'a',
          Node('b'),
          Node('c', Node('d'), Node('e'))
        ).leafList.toSet == Set(
          'b',
          'd',
          'e'
        )
      )
      assert(End.leafList == Nil)
      assert(Node('b', Node('a'), End).leafList == List('a'))
    }
  }
}
