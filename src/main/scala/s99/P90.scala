package s99

import scala.collection.mutable.ListBuffer

object P90 {
  def solve: List[List[Int]] = getPatterns(8)()
  def getPatterns(boardSize: Int)(
      col: Int = 0,
      restRow: Set[Int] = (0 until boardSize).toSet,
      limitations: List[Equation] = Nil
  ): List[List[Int]] =
    if (col == boardSize) List(Nil)
    else {
      val patterns = ListBuffer.empty[List[Int]]
      for (
        row <- restRow
        if limitations.forall(equation => !equation.check(col, row))
      ) {
        val f1 = Equation(Add(X, Y), Const(col + row)) // x + y = col + row
        val f2 = Equation(Y, Add(X, Const(row - col))) // y = x + row - col
        val restPatterns = getPatterns(boardSize)(
          col + 1,
          restRow - row,
          f1 :: f2 :: limitations
        )
        patterns ++= restPatterns.map(restPattern => row :: restPattern)
      }
      patterns.toList
    }

  sealed trait Formula {
    def calc(x: Int, y: Int): Int
  }
  case object X extends Formula {
    override def calc(x: Int, y: Int): Int = x
  }
  case object Y extends Formula {
    override def calc(x: Int, y: Int): Int = y
  }
  case class Const(i: Int) extends Formula {
    override def calc(x: Int, y: Int): Int = i
  }
  case class Add(v1: Formula, v2: Formula) extends Formula {
    override def calc(x: Int, y: Int): Int = v1.calc(x, y) + v2.calc(x, y)
  }
  case class Equation(v1: Formula, v2: Formula) {
    def check(x: Int, y: Int): Boolean = v1.calc(x, y) == v2.calc(x, y)
  }
}
