package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P09Spec extends FunSpec with DiagrammedAssertions {
  describe("P09") {
    it("for empty list, pack(s) is s"){
      assert(P09.pack(List.empty[Int]) ==List.empty[List[Int]])
    }
    it("for list has one element, pack(s) is List(s)"){
      assert(P09.pack(List(1)) == List(List(1)))
    }
    it("otherwise"){
      assert(P09.pack(List(1, 1)) == List(List(1, 1)))
      assert(P09.pack(List(1, 1, 2)) == List(List(1, 1), List(2)))
      assert(P09.pack(List(1, 1, 2, 3)) == List(List(1, 1), List(2), List(3)))
      assert(P09.pack(List(1, 1, 2, 2, 3)) == List(List(1, 1), List(2, 2), List(3)))
    }
  }
}