package jp.co.dwango.s99

object P32 {
  def gcd(x: Int, y: Int): Int = {
    def loop(x: Int, y: Int): Int = {
      if (x.abs > y.abs)
        if (y.abs == 0) x.abs
        else loop(y, x % y)
      else if (x.abs < y.abs)
        if (x.abs == 0) y.abs
        else loop(x, y % x)
      else
        x.abs
    }
    if (x == 0) y.abs else if (y == 0) x.abs else loop(x, y)
  }
}
