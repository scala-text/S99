package jp.co.dwango.s99

object P46 {
  def and(x: Boolean, y: Boolean): Boolean = x & y
  def or(x: Boolean, y: Boolean): Boolean = x | y
  def xor(x: Boolean, y: Boolean): Boolean = x ^ y
  def table2(f: (Boolean, Boolean) => Boolean): Unit = {
    printf("%-6s", "A")
    printf("%-6s", "B")
    printf("%-6s", "result")
    println()
    for (a <- List(true, false); b <- List(true, false)) {
      printf("%-6b", a)
      printf("%-6b", b)
      printf("%-6b", f(a, b))
      println()
    }
  }
}
