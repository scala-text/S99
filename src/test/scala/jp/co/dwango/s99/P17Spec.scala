package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P17Spec extends FunSpec with DiagrammedAssertions {
  describe("P17") {
    it("for index less than 0, split(n, s) throws Exception") {
      intercept[Throwable] {
        P17.split(-1, List.empty[Int])
      }
      intercept[Throwable] {
        P17.split(-1, List(1))
      }
      intercept[Throwable] {
        P17.split(-1, List(1, 2))
      }
    }
    it("for index which is out of range, split(n, s) throws Exception") {
      intercept[Throwable] {
        P17.split(1, List.empty[Int])
      }
      intercept[Throwable] {
        P17.split(-1, List.empty[Int])
      }
      intercept[Throwable] {
        P17.split(2, List(1))
      }
      intercept[Throwable] {
        P17.split(3, List(1, 2))
      }
    }
    it("for 0 index and empty list, split(n, s) returns (List(), List())") {
      assert(
        P17.split(0, List.empty[Int]) == ((List.empty[Int], List.empty[Int])))
    }
    it("otherwise") {
      assert(P17.split(0, List(1, 2)) == ((List(), List(1, 2))))
      assert(P17.split(1, List(1, 2)) == ((List(1), List(2))))
      assert(P17.split(0, List(1, 2, 3)) == ((List(), List(1, 2, 3))))
      assert(P17.split(1, List(1, 2, 3)) == ((List(1), List(2, 3))))
      assert(P17.split(2, List(1, 2, 3)) == ((List(1, 2), List(3))))
      assert(P17.split(3, List(1, 2, 3)) == ((List(1, 2, 3), List())))
    }
  }
}
