package s99

import org.scalatest.funspec.AnyFunSpec

class P14Spec extends AnyFunSpec {
  describe("P14") {
    it("for empty list, duplicate(s) is s") {
      assert(P14.duplicate(List.empty[Int]) == List.empty[Int])
    }
    it("for list has one element") {
      assert(P14.duplicate(List(1)) == List(1, 1))
      assert(P14.duplicate(List(2)) == List(2, 2))
      assert(P14.duplicate(List(3)) == List(3, 3))
      assert(P14.duplicate(List(4)) == List(4, 4))
    }
    it("otherwise") {
      assert(P14.duplicate(List(1, 2, 3)) == List(1, 1, 2, 2, 3, 3))
      assert(P14.duplicate(List(1, 1, 2, 3)) == List(1, 1, 1, 1, 2, 2, 3, 3))
      assert(P14.duplicate(List(1, 2, 3, 3)) == List(1, 1, 2, 2, 3, 3, 3, 3))
      assert(
        P14.duplicate(List(1, 1, 2, 3, 3)) == List(1, 1, 1, 1, 2, 2, 3, 3, 3, 3)
      )
      assert(P14.duplicate(List(1, 2, 2, 3)) == List(1, 1, 2, 2, 2, 2, 3, 3))
    }
  }
}
