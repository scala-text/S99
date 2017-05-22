package jp.co.dwango.s99

import org.scalatest.{DiagrammedAssertions, FunSpec}
import binary_trees._
import P61a._

class P61aSpec extends FunSpec with DiagrammedAssertions  {
  describe("P61a"){
    it("collect value of leaves"){
      assert(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList == List('b','d','e'))
    }
  }
}
