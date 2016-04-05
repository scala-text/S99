package jp.co.dwango.s99

import org.scalacheck.Properties
import org.scalacheck.Prop.{forAll, BooleanOperators}

class P01Check extends Properties("P01"){
  property("last()") = forAll{(s: List[Int]) =>
    (!s.isEmpty) ==> (P01.last(s) == s.last)
  }
}
