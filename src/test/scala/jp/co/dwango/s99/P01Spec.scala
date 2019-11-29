package jp.co.dwango.s99

import org.scalatest.diagrams.Diagrams
import org.scalatest.funspec.AnyFunSpec

class P01Spec extends AnyFunSpec with Diagrams {
  describe("P01") {
    it("for empty list(should fail)") {
      intercept[Throwable] {
        P01.last(List[Int]())
      }
    }
    it("for list has one element") {
      assert(P01.last(List(1)) == 1)
    }
    it("for list has more than one element") {
      assert(P01.last(List(1, 2)) == 2)
    }
  }
}
