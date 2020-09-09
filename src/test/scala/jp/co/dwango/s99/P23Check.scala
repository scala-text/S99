package jp.co.dwango.s99

import org.scalacheck.{Arbitrary, Gen, Prop, Properties}

class P23Check extends Properties("P23") {
  property("randomSelect()") = {
    val gen = for {
      n <- Gen.choose(0, 100)
      s <- Gen.listOfN(n, implicitly[Arbitrary[Int]].arbitrary)
    } yield (s, n)

    Prop.forAll(gen) { case (s, n) =>
      P23.randomSelect(n, s).length == n
    }
  }
}
