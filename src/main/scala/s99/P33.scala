package s99

object P33 {
  implicit class RichInt(self: Int) {
    def isCoPrime(n: Int): Boolean = P32.gcd(self, n) == 1
  }
}
