package s99

import org.scalacheck.{Gen, Properties}
import Gen.listOf, Gen.chooseNum
import org.scalacheck.Prop.{propBoolean, forAll}

class P18Check extends Properties("P18") {
  property("slice()") = forAll(
    listOf(chooseNum(Int.MinValue, Int.MaxValue)),
    chooseNum(0, 10),
    chooseNum(0, 10)
  ) { (s: List[Int], i: Int, j: Int) =>
    (i <= j && j <= s.length) ==> (P18.slice(i, j, s) == s.slice(i, j))
  }
}
