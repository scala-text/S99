package jp.co.dwango.s99

import org.scalatest.funspec.AnyFunSpec

class P04Spec extends AnyFunSpec {
  describe("P04") {
    it("for empty list") {
      assert(P04.length(List.empty[Int]) == 0)
    }
    it("for list has one element") {
      assert(P04.length(List(1)) == 1)
    }
    it("otherwise") {
      assert(P04.length(List(1, 2)) == 2)
      assert(P04.length(List(1, 2, 3)) == 3)
    }
  }
}
