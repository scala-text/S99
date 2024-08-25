package s99

import org.scalacheck.{Gen, Properties}
import Gen.listOf, Gen.chooseNum
import org.scalacheck.Prop.{propBoolean, forAll}

class P17Check extends Properties("P17") {
  property("split()") =
    forAll(listOf(chooseNum(Int.MinValue, Int.MaxValue)), chooseNum(0, 10)) {
      (s: List[Int], i: Int) =>
        i <= s.length ==> (P17.split(i, s) == s.splitAt(i))
    }
}
