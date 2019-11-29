package jp.co.dwango.s99

import org.scalatest.diagrams.Diagrams
import org.scalatest.funspec.AnyFunSpec

class P15Spec extends AnyFunSpec with Diagrams {
  describe("P15") {
    it("for empty list, duplicateN(i, s) is always s") {
      assert(P15.duplicateN(0, List.empty[Int]) == List.empty[Int])
      assert(P15.duplicateN(1, List.empty[Int]) == List.empty[Int])
      assert(P15.duplicateN(2, List.empty[Int]) == List.empty[Int])
      assert(P15.duplicateN(3, List.empty[Int]) == List.empty[Int])
    }
    it("for list has one element") {
      assert(P15.duplicateN(0, List(1)) == List.empty[Int])
      assert(P15.duplicateN(1, List(1)) == List(1))
      assert(P15.duplicateN(2, List(1)) == List(1, 1))
      assert(P15.duplicateN(3, List(1)) == List(1, 1, 1))
    }
    it("otherwise") {
      assert(P15.duplicateN(1, List(1, 2, 3)) == List(1, 2, 3))
      assert(P15.duplicateN(2, List(1, 2, 3)) == List(1, 1, 2, 2, 3, 3))
      assert(P15.duplicateN(1, List(1, 1, 2, 3)) == List(1, 1, 2, 3))
      assert(
        P15.duplicateN(2, List(1, 2, 3, 3)) == List(1, 1, 2, 2, 3, 3, 3, 3)
      )
      assert(
        P15.duplicateN(2, List(1, 1, 2, 3, 3)) == List(1, 1, 1, 1, 2, 2, 3, 3,
          3, 3)
      )
      assert(
        P15.duplicateN(2, List(1, 2, 2, 3)) == List(1, 1, 2, 2, 2, 2, 3, 3)
      )
    }
  }
}
