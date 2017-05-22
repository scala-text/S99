package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}
import binary_trees._
import P62b._

class P62bSpec extends FunSpec with DiagrammedAssertions{
  describe("P62b"){
    it("collect value of specific levels") {
      assert(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2) == List('b','c'))
    }
  }
}
