package jp.co.dwango.s99

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

class P04Check extends Properties("P04") {
  property("length()") = forAll{(n: List[Int]) =>
    P04.length(n) == n.length
  }
}
