package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

/**
  * Created by micchon1 on 2016/04/26.
  */
class P32Spec extends FunSpec with DiagrammedAssertions {
  describe("P32") {
    it("for zero test") {
      assert(P32.gcd(0, 0) == 0)
      assert(P32.gcd(2, 0) == 2)
      assert(P32.gcd(0, 33) == 33)
    }
    it("for positive integer numbers") {
      assert(P32.gcd(3 * 5 * 7 * 11, 3 * 5 * 7 * 11 * 17 * 19) == 3 * 5 * 7 * 11)
      assert(P32.gcd(3, 3) == 3)
      assert(P32.gcd(2 * 3 * 5 * 7, 2 * 3 * 5 * 17)  == 2 * 3 * 5)
    }
    it("for negative integer numbers") {
      assert(P32.gcd(-5, -5) == 5)
      assert(P32.gcd(-2, -4) == 2)
    }
  }
}
