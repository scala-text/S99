package jp.co.dwango.s99

import org.scalacheck.{Prop, Properties, Gen}

class P27aCheck extends Properties("P27a") {
  property("group3()") = {
    val gen = for {
      g <- Gen.listOfN(9, Gen.choose(Int.MinValue, Int.MaxValue))
      if g.distinct.length == g.length
    } yield g
    Prop.forAll(gen) { (s: List[Int]) =>
      val sorted = s.sorted
      val a = P27a.group3(sorted)
      a.forall { b => b.flatten.sorted == sorted }
    }
  }
}
