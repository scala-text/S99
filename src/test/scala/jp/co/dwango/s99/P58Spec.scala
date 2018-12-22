package jp.co.dwango.s99

import jp.co.dwango.s99.P58.Tree
import jp.co.dwango.s99.binary_trees.{Node, End}
import org.scalatest.{DiagrammedAssertions, FunSpec}

class P58Spec extends FunSpec with DiagrammedAssertions {
  describe("P58") {
    it("""Tree.symmetricBalancedTrees(5, "x")""") {
      assert(
        List(
          Node(
            "x",
            Node("x", End, Node("x")),
            Node("x", Node("x", End, End), End)
          ),
          Node("x", Node("x", Node("x"), End), Node("x", End, Node("x")))
        ) ==
          Tree.symmetricBalancedTrees(5, "x")
      )
    }
  }
}
