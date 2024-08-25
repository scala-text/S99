package s99

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

class P13Check extends Properties("P13") {
  property("encodeDirect(), which should be same result with encode()") =
    forAll { (s: List[Int]) => P13.encodeDirect(s) == P10.encode(s) }
}
