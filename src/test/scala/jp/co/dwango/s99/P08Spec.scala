package jp.co.dwango.s99

import org.scalatest.diagrams.Diagrams
import org.scalatest.funspec.AnyFunSpec

class P08Spec extends AnyFunSpec with Diagrams {
  describe("P08") {
    it("for empty list, compress(s) is s") {
      assert(P08.compress(List.empty[Int]) == List.empty[Int])
    }
    it("for list has one element, compress(s) is s") {
      assert(P08.compress(List(1)) == List(1))
    }
    it("otherwise") {
      assert(P08.compress(List(1, 1)) == List(1))
      assert(P08.compress(List(1, 2, 1)) == List(1, 2, 1))
      assert(P08.compress(List(1, 2, 2)) == List(1, 2))
    }
  }
}
