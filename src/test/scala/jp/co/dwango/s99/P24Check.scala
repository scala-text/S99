package jp.co.dwango.s99

import org.scalacheck.{Gen, Prop, Properties}

class P24Check extends Properties("P24") {
  property("lotto()") = {
    val gen = for {
      m <- Gen.choose(1, 100)
      n <- Gen.choose(0, m - 1)
    } yield (n, m)

    Prop.forAll(gen) { case (n, m) =>
      val lotto = P24.lotto(n, m)
      lotto.distinct == lotto
    }
  }
}
