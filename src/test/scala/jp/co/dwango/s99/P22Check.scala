package jp.co.dwango.s99

import org.scalacheck.{Arbitrary, Gen, Prop, Properties}

class P22Check extends Properties("P22") {
  property("range()") = {
    val gen = for {
      from <- implicitly[Arbitrary[Int]].arbitrary
      toByLong = from + 100L //to avoid overflow
      to <- Gen.choose(
        from,
        if (toByLong > Int.MaxValue) Int.MaxValue else from + 100)
    } yield (from, to)

    Prop.forAll(gen) {
      case (from, to) =>
        P22.range(from, to) == (from to to).toList
    }
  }
}
