package jp.co.dwango.s99

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

class P14Check extends Properties("P14") {
  property("duplicate()") = forAll { (s: List[Int]) =>
    P14.duplicate(s) == s.map { x => List(x, x) }.flatten
  }
}
