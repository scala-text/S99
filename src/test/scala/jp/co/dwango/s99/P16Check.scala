package jp.co.dwango.s99

import org.scalacheck.{Gen, Properties}
import Gen.listOf, Gen.chooseNum
import org.scalacheck.Prop.{BooleanOperators, forAll}

class P16Check extends Properties("P16") {
  property("drop()") = forAll(listOf(chooseNum(Int.MinValue, Int.MaxValue)), chooseNum(-1, 10)){ (s: List[Int], i: Int) =>
    (0 < i && i <= s.length) ==> (P16.drop(i, s) == s.zipWithIndex.map{ case (e, j) =>(e, j +1) }.filterNot { case (e, j) =>
      j % i == 0
    }.map{_._1})
  }
}
