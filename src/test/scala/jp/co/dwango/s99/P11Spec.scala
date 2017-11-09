package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P11Spec extends FunSpec with DiagrammedAssertions {
  describe("P11") {
    it("for empty list, encodeModified(s) is s") {
      assert(P11.encodeModified(List.empty[Int]) == List.empty[Int])
    }
    it("for list has one element, encodeModified(s) is s") {
      assert(P11.encodeModified(List(1)) == List(1))
      assert(P11.encodeModified(List(2)) == List(2))
      assert(P11.encodeModified(List(2)) == List(2))
    }
    it("otherwise") {
      assert(P11.encodeModified(List(1, 1)) == List((2, 1)))
      assert(P11.encodeModified(List(1, 1, 2)) == List((2, 1), 2))
      assert(P11.encodeModified(List(1, 1, 2, 3)) == List((2, 1), 2, 3))
      assert(P11.encodeModified(List(1, 1, 2, 2, 3)) == List((2, 1), (2, 2), 3))
    }
  }
}
