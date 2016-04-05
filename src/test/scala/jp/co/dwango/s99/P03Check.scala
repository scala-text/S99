package jp.co.dwango.s99

import org.scalacheck.{Gen, Properties}
import Gen.listOf, Gen.chooseNum
import org.scalacheck.Prop.{BooleanOperators, forAll}

class P03Check extends Properties("P03") {
  property("nth()") = forAll(listOf(chooseNum(Int.MinValue, Int.MaxValue)), chooseNum(-1, 10)){ (s: List[Int], i: Int) =>
    (0 <= i && i < s.length) ==> (P03.nth(i, s) == s(i))
  }
}
