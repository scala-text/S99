package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P02Spec extends FunSpec with DiagrammedAssertions {
  describe("P02") {
    it("for empty list(should fail)") {
      intercept[Throwable] {
        P02.penultimate(List[Int]())
      }
    }
    it("for list has one element(also should fail)") {
      intercept[Throwable] {
        P02.penultimate(List(1))
      }
    }
    it("for list has more than one element") {
      assert(P02.penultimate(List(1, 2)) == 1)
    }
    it("for list has more than two element") {
      assert(P02.penultimate(List(1, 2, 3)) == 2)
    }
  }
}
