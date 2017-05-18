package jp.co.dwango.s99

import org.scalacheck.Properties
import org.scalacheck.Prop.{forAll, BooleanOperators}

class P02Check extends Properties("P02") {
  property("penultimate()") = forAll { (s: List[Int]) =>
    (s.length >= 2) ==> (P02.penultimate(s) == s(s.length - 2))
  }
}
