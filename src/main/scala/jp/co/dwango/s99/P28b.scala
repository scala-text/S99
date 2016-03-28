package jp.co.dwango.s99

import Util.map
import Util.foldLeft
import P04.length
import P28a.mergeSort

object P28b {
  def lsortFreq[T](list: List[List[T]]): List[List[T]] = {
    val listl = map(list)(x => (x, length(x)))
    val freqs = foldLeft(listl, Map[Int, Int]()){ case (map, (lst, len)) =>
      map.updated(len, map.getOrElse(len, 0) + 1)
    }
    map(mergeSort(map(listl)(x => (x._1, freqs(x._2))))(_._2 < _._2))(_._1)
  }
}

