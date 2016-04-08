package jp.co.dwango.s99

import org.scalacheck.{Prop, Properties, Gen, Arbitrary}

class P27bCheck extends Properties("P27b") {
  property("group()") = {
    val gen = for {
      g1 <- Gen.listOfN(3, Gen.choose(1, 3)) // To avoid StackOverflowError, small numbers are chosen
      g2 <- Gen.listOfN(g1.sum, implicitly[Arbitrary[Int]].arbitrary)
      if g2.distinct.length == g2.length
    } yield (g1, g2)

    Prop.forAll(gen){ case (s1: List[Int], s2: List[Int]) =>
      val a: List[List[List[Int]]] = P27b.group(s1, s2)
      a.forall{b => s1.length == b.length && b.zip(s1).forall{ case (c, n) => c.length == n && c.distinct.length == c.length}}
    }
  }
}
