package jp.co.dwango.s99

import org.scalacheck.{Gen, Properties}
import Gen.listOf, Gen.chooseNum
import org.scalacheck.Prop.{BooleanOperators, forAll}

class P04Check extends Properties("P04") {
  property("length()") = forAll{(n: List[Int]) =>
    P04.length(n) == n.length
  }
}
