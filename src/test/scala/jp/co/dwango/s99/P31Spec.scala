package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}
import P31._

class P31Spec extends FunSpec with DiagrammedAssertions {
  describe("P31") {
    it("for prime number") {
      assert(2.isPrime)
      assert(5.isPrime)
      assert(19.isPrime)
      assert(937.isPrime)
    }
    it("for not prime number(even)") {
      assert(!4.isPrime)
      assert(!28.isPrime)
      assert(!1024.isPrime)
      assert(!4800.isPrime)
    }
    it("for not prime number(odd)") {
      assert(!9.isPrime)
      assert(!49.isPrime)
      assert(!(13 * 17).isPrime)
      assert(!(23 * 27).isPrime)
    }
  }
}
