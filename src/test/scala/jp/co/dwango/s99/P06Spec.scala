package jp.co.dwango.s99

import org.scalatest.diagrams.Diagrams
import org.scalatest.funspec.AnyFunSpec

class P06Spec extends AnyFunSpec with Diagrams {
  describe("P06") {
    it("for empty list, isPalindrome(s) should be true") {
      assert(P06.isPalindrome(List.empty[Int]))
    }
    it("for list has one element, isPalindrome(s) should be true") {
      assert(P06.isPalindrome(List(1)))
    }
    it("otherwise") {
      assert(P06.isPalindrome(List(1, 2, 1)))
    }
  }
}
