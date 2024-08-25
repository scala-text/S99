package s99

import org.scalacheck.{Prop, Properties}

class P28aCheck extends Properties("P28a") {
  property("lsort()") = {
    Prop.forAll { (s: List[List[Int]]) =>
      val a = P28a.lsort(s)
      if (a.length < 2) {
        true
      } else {
        a.zip(a.tail).forall { case (l, r) => l.length <= r.length }
      }
    }
  }
}
