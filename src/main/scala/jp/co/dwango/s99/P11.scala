package jp.co.dwango.s99

import Util.map
import P04.length
import P09.pack

object P11 {
  def encodeModified(list: List[Any]): List[Any] = {
    map(pack(list)) { x =>
      length(x) match {
        case 1 => x.head
        case n => (n, x.head)
      }
    }
  }
}
