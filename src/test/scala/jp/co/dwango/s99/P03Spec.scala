package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P03Spec extends FunSpec with DiagrammedAssertions {
  describe("P03") {
    it("any index with empty list should fail") {
      val emptyList = List.empty[Int]
      intercept[Throwable] {
        P03.nth(0, emptyList)
      }
      intercept[Throwable] {
        P03.nth(1, emptyList)
      }
      intercept[Throwable] {
        P03.nth(-1, emptyList)
      }
    }
    it("0 index with a list") {
      intercept[Throwable] {
        P03.nth(0, List.empty[Int])
      }
      assert(P03.nth(0, List(2)) == 2)
      assert(P03.nth(0, List(2, 3)) == 2)
    }
    it("negative index with a list should fail") {
      intercept[Throwable] {
        P03.nth(-1, List.empty[Int])
      }
      intercept[Throwable] {
        P03.nth(-1, List(2))
      }
      intercept[Throwable] {
        P03.nth(-1, List(2, 3))
      }
    }
    it("otherwise") {
      intercept[Throwable] {
        P03.nth(1, List(2))
      }
      assert(P03.nth(1, List(2, 3)) == 3)
    }
  }
}
