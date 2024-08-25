package s99

import s99.P58.Tree
import s99.binary_trees.{Node, End}

import org.scalatest.funspec.AnyFunSpec

class P58Spec extends AnyFunSpec {
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
