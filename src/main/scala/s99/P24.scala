package s99

import P22.range
import P23.randomSelect

object P24 {
  def lotto(n: Int, m: Int): List[Int] = randomSelect(n, range(1, m))
}
