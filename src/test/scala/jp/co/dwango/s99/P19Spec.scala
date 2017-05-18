package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P19Spec extends FunSpec with DiagrammedAssertions {
  describe("P19") {
    it("for empty list, rotate(n, s) throws Exception") {
      intercept[Throwable] {
        P19.rotate(-2, List.empty[Int])
      }
      intercept[Throwable] {
        P19.rotate(-1, List.empty[Int])
      }
      intercept[Throwable] {
        P19.rotate(0, List.empty[Int])
      }
      intercept[Throwable] {
        P19.rotate(1, List.empty[Int])
      }
      intercept[Throwable] {
        P19.rotate(2, List.empty[Int])
      }
    }
    it("for list one element, rotate(n, s) returns s itself") {
      assert(P19.rotate(-2, List(1)) == List(1))
      assert(P19.rotate(-1, List(1)) == List(1))
      assert(P19.rotate(-0, List(1)) == List(1))
      assert(P19.rotate(-1, List(1)) == List(1))
      assert(P19.rotate(-2, List(1)) == List(1))
    }
    it("otherwise") {
      assert(P19.rotate(-3, List(1, 2)) == List(2, 1))
      assert(P19.rotate(-2, List(1, 2)) == List(1, 2))
      assert(P19.rotate(-1, List(1, 2)) == List(2, 1))
      assert(P19.rotate(0, List(1, 2)) == List(1, 2))
      assert(P19.rotate(1, List(1, 2)) == List(2, 1))
      assert(P19.rotate(2, List(1, 2)) == List(1, 2))
      assert(P19.rotate(3, List(1, 2)) == List(2, 1))
    }
  }
}
