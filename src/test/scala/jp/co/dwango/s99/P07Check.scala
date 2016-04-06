package jp.co.dwango.s99

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

class P07Check extends Properties("P07") {
  property("flatten()") = forAll{ (s: List[List[Int]]) =>
    P07.flatten(s) == s.flatten
  }
}
