package jp.co.dwango.s99

import scala.collection.mutable

object P49 {
  def gray(n: Int): List[String] = {
    if(n == 0) {
      List("")
    } else {
      val r = gray(n - 1)
      val resultL = r.map{xs => "0" + xs}
      val resultR = r.reverse.map{xs => "1" + xs}
      resultL ::: resultR
    }
  }
}
