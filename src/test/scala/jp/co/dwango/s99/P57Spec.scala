package jp.co.dwango.s99

import jp.co.dwango.s99.P57.Tree
import jp.co.dwango.s99.P56._
import org.scalatest.diagrams.Diagrams
import org.scalatest.funspec.AnyFunSpec

class P57Spec extends AnyFunSpec with Diagrams {
  describe("P57") {
    it("Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)") {
      assert(Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric)
    }
    it("Tree.fromList(List(3, 2, 5, 7, 4))") {
      assert(!Tree.fromList(List(3, 2, 5, 7, 4)).isSymmetric)
    }
  }
}
