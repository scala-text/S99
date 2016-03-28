package jp.co.dwango.s99

import P05.reverse

object P06 {
  def isPalindrome[T](list: List[T]): Boolean = {
    reverse(list) == list
  }
}
