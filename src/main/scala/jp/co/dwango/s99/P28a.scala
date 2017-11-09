package jp.co.dwango.s99

import Util.map
import Util.split

import P04.length

object P28a {
  def mergeSort[T](list: List[T])(lt: (T, T) => Boolean): List[T] = {
    def merge(list1: List[T], list2: List[T]): List[T] = {
      (list1, list2) match {
        case (x :: xs, y :: ys) if lt(x, y) => x :: merge(xs, list2)
        case (x :: xs, y :: ys)             => y :: merge(list1, ys)
        case (Nil, ys)                      => ys
        case (xs, Nil)                      => xs
      }
    }
    def mergeSort1(list: List[T], len: Int): List[T] = len match {
      case 0 => Nil
      case 1 => list
      case _ =>
        val m = len / 2
        val (fst, snd) = split(m, list)
        merge(mergeSort1(fst, m), mergeSort1(snd, len - m))
    }
    mergeSort1(list, length(list))
  }

  def lsort[T](list: List[List[T]]): List[List[T]] = {
    map(mergeSort(map(list)(x => (x, length(x))))(_._2 < _._2))(_._1)
  }
}
