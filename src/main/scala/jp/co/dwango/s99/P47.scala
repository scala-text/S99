package jp.co.dwango.s99

object P47 {
  implicit class RichBoolean(val self: Boolean) extends AnyVal {
    def and(y: Boolean): Boolean = self & y
    def or(y: Boolean): Boolean = self | y
    def xor(y: Boolean): Boolean = self ^ y
  }
  def not(x: Boolean): Boolean = !x
  def table2(f: (Boolean, Boolean) => Boolean): Unit = {
    printf("%-6s", "A")
    printf("%-6s", "B")
    printf("%-6s", "result")
    println()
    for(a <- List(true, false); b <- List(true, false)) {
      printf("%-6b", a)
      printf("%-6b", b)
      printf("%-6b", f(a, b))
      println()
    }
  }
}
