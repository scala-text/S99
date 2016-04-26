package jp.co.dwango.s99

object P31 {
  implicit def isPrime(x: Int) = new {
    def isPrime(): Boolean = {
      val nums = 2 to x
      (x > 1) && nums.takeWhile(_ <= Math.sqrt(x)).forall(x % _ != 0)
    }
  }
}
