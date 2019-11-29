package jp.co.dwango.s99

import P49.gray
import P49.gray2
import org.scalatest.diagrams.Diagrams
import org.scalatest.funspec.AnyFunSpec

class P49Spec extends AnyFunSpec with Diagrams {
  describe("P49") {
    it("gray(1)") {
      assert(gray(1) == List("0", "1"))
    }
    it("gray(2)") {
      assert(gray(2) == List("00", "01", "11", "10"))
    }
    it("gray(3)") {
      assert(
        gray(3) == List("000", "001", "011", "010", "110", "111", "101", "100")
      )
    }
    it("gray2(1)") {
      assert(gray2(1) == List("0", "1"))
    }
    it("gray2(2)") {
      assert(gray2(2) == List("00", "01", "11", "10"))
    }
    it("gray2(3)") {
      assert(
        gray2(3) == List("000", "001", "011", "010", "110", "111", "101", "100")
      )
    }
  }
}
