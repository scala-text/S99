package jp.co.dwango.s99

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

class P08Check extends Properties("P08") {
  def duplicates(list: List[Int]): Int = {
    @scala.annotation.tailrec
    def loop(list: List[Int], curr: Int, count: Int): Int = list match {
      case Nil => count
      case x :: xs =>
        if (curr == x) loop(xs, curr, count + 1) else loop(xs, x, count)
    }
    list match {
      case x :: xs => loop(xs, x, 0)
      case Nil     => 0
    }
  }
  property("compress()") = forAll { (s: List[Int]) =>
    P08.compress(s).length == s.length - duplicates(s)
  }
}
