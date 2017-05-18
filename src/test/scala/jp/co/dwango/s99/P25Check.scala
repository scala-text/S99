package jp.co.dwango.s99

import org.scalacheck.{Prop, Properties}

class P25Check extends Properties("P25") {
  property("randomPermute()") = {
    Prop.forAll { (n: List[Int]) =>
      P25.randomPermute(n).sorted == n.sorted
    }
  }
}
