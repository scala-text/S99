package jp.co.dwango.s99

import org.scalacheck.{Arbitrary, Gen, Prop, Properties}

class P21Check extends Properties("P21") {
  property("removeAt()") = {
    val gen = for {
      x <- Gen.choose(1, 10)
      y <- Gen.choose(0, x - 1)
      e <- implicitly[Arbitrary[Int]].arbitrary
      s <- Gen.listOfN(x, implicitly[Arbitrary[Int]].arbitrary)
    } yield (s, y, e)

    Prop.forAll(gen){ case (s, i, e) =>
      P21.insertAt(e, i, s) == {
        val buf = s.toBuffer
        buf.insert(i, e)
        buf.toList
      }
    }
  }
}
