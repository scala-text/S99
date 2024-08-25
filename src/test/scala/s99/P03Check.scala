package s99

import org.scalacheck.{Arbitrary, Gen, Prop, Properties}

class P03Check extends Properties("P03") {
  property("nth()") = {
    val gen = for {
      x <- Gen.choose(1, 10)
      y <- Gen.choose(0, x - 1)
      s <- Gen.listOfN(x, implicitly[Arbitrary[Int]].arbitrary)
    } yield (s, y)

    Prop.forAll(gen) { case (s, i) =>
      P03.nth(i, s) == s(i)
    }
  }
}
