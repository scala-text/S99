package s99

import org.scalatest.funspec.AnyFunSpec

class P16Spec extends AnyFunSpec {
  describe("P16") {
    it("for index less than equal 0, drop(i, s) throws Exception") {
      intercept[Throwable] {
        P16.drop(0, List.empty[Int])
      }
      intercept[Throwable] {
        P16.drop(-1, List.empty[Int])
      }
      intercept[Throwable] {
        P16.drop(0, List(1))
      }
      intercept[Throwable] {
        P16.drop(-1, List(1))
      }
    }
    it("for positive index and empty list, drop(i, s) is empty list") {
      assert(P16.drop(1, List.empty[Int]) == List.empty[Int])
      assert(P16.drop(2, List.empty[Int]) == List.empty[Int])
      assert(P16.drop(3, List.empty[Int]) == List.empty[Int])
    }
    it("otherwise") {
      assert(P16.drop(1, List(1)) == List.empty[Int])
      assert(P16.drop(1, List(1, 2)) == List.empty[Int])
      assert(P16.drop(1, List(1, 2, 3)) == List.empty[Int])
      assert(P16.drop(2, List(1, 2)) == List(1))
      assert(P16.drop(2, List(1, 2, 3)) == List(1, 3))
      assert(P16.drop(2, List(0, 0)) == List(0))
    }
  }
}
