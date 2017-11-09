package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P13Spec extends FunSpec with DiagrammedAssertions {
  describe("P13") {
    it("for empty list, encodeDirect(s) is s") {
      assert(P13.encodeDirect(List.empty[Int]) == List.empty[(Int, Int)])
    }
    it("for list has one element, encodeDirect(s) is List((1, s))") {
      assert(P13.encodeDirect(List(2)) == List((1, 2)))
    }
    it("otherwise") {
      assert(P13.encodeDirect(List(1, 1)) == List((2, 1)))
      assert(P13.encodeDirect(List(1, 1, 2)) == List((2, 1), (1, 2)))
      assert(P13.encodeDirect(List(1, 1, 2, 3)) == List((2, 1), (1, 2), (1, 3)))
      assert(
        P13.encodeDirect(List(1, 1, 2, 2, 3)) == List((2, 1), (2, 2), (1, 3)))
    }
  }
}
