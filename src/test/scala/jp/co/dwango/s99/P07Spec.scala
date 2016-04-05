package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}

class P07Spec extends FunSpec with DiagrammedAssertions {
  describe("P07") {
    it("for empty list, flatten(s) is s"){
      assert(P07.flatten(List.empty[Int]) == List.empty[Int])
    }
    it("for list of empty list, flatten(List(List.empty)) is List.empty"){
      assert(P07.flatten(List(List.empty[Int])) == List.empty[Int])
    }
    it("otherwise"){
      assert(P07.flatten(List(List(1))) ==List(1))
    }
  }
}
