package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P05Spec extends FunSpec with DiagrammedAssertions {
  describe("P05") {
    it("for empty list, reverse(s) should be itself") {
      assert(P05.reverse(List.empty[Int]) == List.empty[Int])
    }
    it("for list has one element, reverse(s) should be itself") {
      assert(P05.reverse(List(1)) == List(1))
    }
    it("otherwise") {
      assert(P05.reverse(List(1, 2)) == List(2, 1))
    }
  }
}
