package s99

object P31 {
  implicit class RichInt(self: Int) {
    def isPrime: Boolean = {
      val nums = 2 to self
      (self > 1) && nums.takeWhile(_ <= Math.sqrt(self)).forall(self % _ != 0)
    }
  }
}
