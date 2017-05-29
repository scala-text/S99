package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}
import P90._

class P90Spec extends FunSpec with DiagrammedAssertions {
  describe("P90") {
    it("solve n queens problem") {
      assert(getPatterns(4)() == List(List(1, 3, 0, 2), List(2, 0, 3, 1)))
      assert(getPatterns(5)().size == 10)
      assert(getPatterns(6)().size == 4)
      assert(getPatterns(7)().size == 40)
      assert(getPatterns(8)().size == 92)
      assert(solve.size == 92)
    }
  }
}
