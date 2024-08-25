package s99

import scala.collection.mutable

object P49 {
  def gray(n: Int): List[String] = {
    if (n == 0) {
      List("")
    } else {
      val r = gray(n - 1)
      val resultL = r.map { xs => "0" + xs }
      val resultR = r.reverse.map { xs => "1" + xs }
      resultL ::: resultR
    }
  }

  def gray2(n: Int): List[String] = {
    val len = Math.pow(2, n).toInt
    val buffer = mutable.ListBuffer[String]()
    for (i <- 0 until len) {
      val g = Integer.toBinaryString(i ^ (i >> 1))
      buffer.append(("0" * (n - g.length)) + g)
    }
    buffer.toList
  }
}
