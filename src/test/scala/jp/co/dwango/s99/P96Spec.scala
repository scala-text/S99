package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}
import P96._

class P96Spec extends FunSpec with DiagrammedAssertions {
  describe("P96") {
    it("for letter parser") {
      assert(letter("a") == Success(""))
      assert(letter("abc") == Success("bc"))
    }
    it("for ~ parser") {
      val ab = letter ~ letter
      assert(ab("abc") == Success("c"))
    }
    it("for ? parser") {
      val p1 = letter.?
      assert(p1("abc") == Success("bc"))
      assert(p1("123") == Success("123"))
      val p2 = letter ~ letter.?
      assert(p2("a12") == Success("12"))
      assert(p2("ab1") == Success("1"))
      assert(p2("abc") == Success("c"))
    }
    it("for | parser") {
      val p1 = letter | digit
      assert(p1("abc") == Success("bc"))
      assert(p1("123") == Success("23"))
    }
    it("for identifier parser") {
      assert(identifier("abc") == Success(""))
      assert(identifier("Time_of_Day") == Success(""))
      assert(identifier("only_1_percent") == Success(""))
      assert(identifier("abc123_xyz") == Success(""))
    }
  }
}
