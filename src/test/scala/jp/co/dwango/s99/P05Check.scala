package jp.co.dwango.s99

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

class P05Check extends Properties("P05") {
  property("reverse()") = forAll{(n: List[Int]) =>
    P05.reverse(P05.reverse(n)) == n
  }
}
