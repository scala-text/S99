package jp.co.dwango.s99

import org.scalacheck.{Prop, Properties}

class P28bCheck extends Properties("P28b") {
  property("lsortFreq()") = {
    Prop.forAll { (s: List[List[Int]]) =>
      val freqs = s.foldLeft(Map.empty[Int, Int]) {
        case (m, e) =>
          val value = m.getOrElse(e.length, 0)
          m.updated(e.length, value + 1)
      }
      val a = P28b.lsortFreq(s)
      if (a.length < 2) {
        true
      } else {
        a.zip(a.tail).forall {
          case (l, r) => freqs(l.length) <= freqs(r.length)
        }
      }
    }
  }
}
