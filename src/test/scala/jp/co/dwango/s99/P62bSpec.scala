package jp.co.dwango.s99

import binary_trees._
import P62b._

import org.scalatest.funspec.AnyFunSpec

class P62bSpec extends AnyFunSpec {
  describe("P62b") {
    it("collect value of specific levels") {
      assert(
        Node('a', Node('b'), Node('c', Node('d'), Node('e')))
          .atLevel(2) == List('b', 'c')
      )
    }
  }
}
