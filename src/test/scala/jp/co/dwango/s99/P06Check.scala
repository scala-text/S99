package jp.co.dwango.s99

import org.scalacheck.{Gen, Properties}
import Gen.listOf, Gen.chooseNum
import org.scalacheck.Prop.forAll

class P06Check extends Properties("P06") {
  private[this] val palindromes: Gen[List[Int]] =
    listOf(chooseNum(Int.MinValue, Int.MaxValue)).map { x => x ++ x.reverse }
  property("isPalindrome()") = forAll(palindromes) { (s: List[Int]) =>
    P06.isPalindrome(s)
  }
}
