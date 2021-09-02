package jp.co.dwango.s99

import org.scalatest.funspec.AnyFunSpec

class P12Spec extends AnyFunSpec {
  describe("P12") {
    it("for empty list, decode(s) is s") {
      assert(P12.decode(List.empty[(Int, Int)]).isEmpty)
    }
    it("for list has one element") {
      assert(P12.decode(List((1, 1))) == List(1))
      assert(P12.decode(List((2, 1))) == List(1, 1))
      assert(P12.decode(List((3, 1))) == List(1, 1, 1))
    }
    it("otherwise") {
      assert(P12.decode(List((1, 1), (1, 2))) == List(1, 2))
      assert(P12.decode(List((2, 1), (1, 2), (1, 3))) == List(1, 1, 2, 3))
      assert(P12.decode(List((2, 1), (2, 2), (1, 3))) == List(1, 1, 2, 2, 3))
    }
  }
}
