package jp.co.dwango.s99

object Util {
  def append[T](a: List[T], b: List[T]): List[T] = a match {
    case Nil     => b
    case x :: xs => x :: append(xs, b)
  }
  def foldLeft[A, B](list: List[A], b: B)(f: (B, A) => B): B = {
    list match {
      case x :: xs => foldLeft(xs, f(b, x))(f)
      case Nil     => b
    }
  }
  def map[A, B](list: List[A])(f: A => B): List[B] = list match {
    case x :: xs => f(x) :: map(xs)(f)
    case Nil     => Nil
  }
  def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = {
    foldLeft(list, List[B]()) { (b, a) =>
      append(b, f(a))
    }
  }
  def copyN[T](t: T, n: Int): List[T] = n match {
    case 0          => List()
    case n if n > 0 => t :: copyN(t, n - 1)
    case _          => sys.error("")
  }

  def split[T](n: Int, list: List[T]): (List[T], List[T]) = list match {
    case xs if n == 0 => (List[T](), xs)
    case x :: xs if n > 0 =>
      split(n - 1, xs) match { case (a, b) => (x :: a, b) }
    case _ => sys.error("")
  }
}
