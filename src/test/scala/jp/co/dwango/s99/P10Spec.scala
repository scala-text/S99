package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P10Spec extends FunSpec with DiagrammedAssertions {
  describe("P10") {
    it("for empty list, encode(s) is s") {
      assert(P10.encode(List.empty[Int]) == List.empty[(Int, Int)])
    }
    it("for list has one element, encode(s) is List((1, s))") {
      assert(P10.encode(List(2)) == List((1, 2)))
    }
    it("otherwise") {
      assert(P10.encode(List(1, 1)) == List((2, 1)))
      assert(P10.encode(List(1, 1, 2)) == List((2, 1), (1, 2)))
      assert(P10.encode(List(1, 1, 2, 3)) == List((2, 1), (1, 2), (1, 3)))
      assert(P10.encode(List(1, 1, 2, 2, 3)) == List((2, 1), (2, 2), (1, 3)))
    }
  }
}
