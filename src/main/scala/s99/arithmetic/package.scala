package s99

import P10.encode

package object arithmetic {
  implicit class S99Int(val self: Int) extends AnyVal {
    def isPrime: Boolean = (3 to (self - 1)).forall(self % _ != 0)
    def primeFactors: List[Int] = {
      def numbers(from: Int): Stream[Int] =
        Stream.cons(from, numbers(from + 1))
      lazy val primes: Stream[Int] = numbers(3).filter(_.isPrime)
      def primeFactorsR(n: Int, ps: Stream[Int]): List[Int] =
        if (n.isPrime) List(n)
        else if (n % ps.head == 0) ps.head :: primeFactorsR(n / ps.head, ps)
        else primeFactorsR(n, ps.tail)
      primeFactorsR(self, primes)
    }
    def primeFactorMultiplicity: List[(Int, Int)] = {
      encode(self.primeFactors).map { _.swap }
    }
  }
}
