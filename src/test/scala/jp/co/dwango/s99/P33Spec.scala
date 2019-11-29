package jp.co.dwango.s99

import P33.RichInt
import org.scalatest.diagrams.Diagrams
import org.scalatest.funspec.AnyFunSpec

class P33Spec extends AnyFunSpec with Diagrams {
  describe("P33") {
    it("for coprime numbers, x.isCoprime(y) returns true") {
      assert(3.isCoPrime(8))
      assert(12.isCoPrime(25))
      assert(64.isCoPrime(35))
      assert(98.isCoPrime(27))
    }
    it("for non-coprime numbers, x.isCoprime(y) returns false") {
      assert(!4.isCoPrime(16))
      assert(!13.isCoPrime(39))
      assert(!48.isCoPrime(4))
      assert(!56.isCoPrime(42))
    }
  }
}
