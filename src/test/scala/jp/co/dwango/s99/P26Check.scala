package jp.co.dwango.s99

import org.scalacheck.{Prop, Gen, Arbitrary, Properties}

class P26Check extends Properties("P26") {
  property("combinations()") = {
    val gen = for {
      n <- Gen.choose(0, 10)
      s <- Gen.listOfN(n + 5, implicitly[Arbitrary[Int]].arbitrary)
    } yield (s, n)

    Prop.forAll(gen){ case (s, n) =>
      val lc = P26.combinations(n, s).map{_.sorted}
      val rc = s.combinations(n).map{_.sorted}.toList
      lc.exists {l => rc.contains(l)} && rc.exists { r => lc.contains(r)}
    }
  }
}
