package jp.co.dwango.s99

import jp.co.dwango.s99.binary_trees.{Tree}
import P56._

object P58 {
  object Tree {
    def symmetricBalancedTrees[T](
        numberOfElements: Int,
        content: T
    ): List[Tree[T]] = {
      P55.Tree.cBalanced(numberOfElements, content).filter { _.isSymmetric }
    }
  }
}
