package jp.co.dwango.s99

import org.scalacheck.{Arbitrary, Gen, Prop, Properties}

class P20Check extends Properties("P20") {
  property("removeAt()") = {
    val gen = for {
      x <- Gen.choose(1, 10)
      y <- Gen.choose(0, x - 1)
      s <- Gen.listOfN(x, implicitly[Arbitrary[Int]].arbitrary)
    } yield (s, y)

    Prop.forAll(gen) { case (s, i) =>
      P20.removeAt(i, s)._1 == s.zipWithIndex
        .filterNot { case (_, j) => i == j }
        .map { _._1 }
    }
  }
}
