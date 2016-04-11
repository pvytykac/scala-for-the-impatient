package org.pvytykac.sfti

import util.Random.nextInt
import collection.mutable.ArrayBuffer

// Chapter 3
object Arrays extends App {

  // 1. Write a code snippet that sets a to an array of n random integers between 0
  //    (inclusive) and n (exclusive).
  def randomArr(n: Int) = {
    for(_ <- 1 to n) yield nextInt(n)
  }

  // 2. Write a loop that swaps adjacent elements of an array of integers. For example,
  //    Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
  //    TODO: generic xor swap
  //    def swap(x: Int, y: Int) = {
  //      arr(x) = arr(x) ^ arr(y)
  //      arr(y) = arr(x) ^ arr(y)
  //      arr(x) = arr(x) ^ arr(y)
  //    }

  def swap[T](arr:Array[T], x:Int, y:Int) {
    val tmp = arr(x)
    arr(x) = arr(y)
    arr(y) = tmp
  }

  def moveSwapAdjacentPatternMatch[T](arr: Array[T]) {
    for(i <- arr.indices) {
      i match {
        case c if c < arr.length - 1 && c % 2 == 0 => swap(arr, i + 1, i)
        case _ => // no-op
      }
    }
  }

  def moveSwapAdjacentFor[T](arr: Array[T]) {
    for(i <- arr.indices if i < arr.length - 1 && i % 2 == 0) {
      swap(arr, i + 1, i)
    }
  }

  // 3. Repeat the preceding assignment, but produce a new array with the swapped
  //    values. Use for/yield.
  //    TODO: generics
  def copySwapAdjacentPatternMatch(arr: Array[Double]): Array[Double] = {
    for(el <- arr) yield {
      val i = arr.indexOf(el)
      i match {
        case c if c < arr.length - 1 && c % 2 == 0 => arr(i + 1)
        case c if c % 2 != 0 => arr(i - 1)
        case _ => arr(i)
      }
    }
  }

  def copySwapAdjacentFlatMap(arr: Array[Double]) = {
    arr.grouped(2).flatMap{
      case Array(a,b) => Array(b,a)
      case Array(a) => Array(a)
    }.toArray
  }

  // 4. Given an array of integers, produce a new array that contains all positive
  //    values of the original array, in their original order, followed by all values that
  //    are zero or negative, in their original order.
  def reorderFor(arr: Array[Int]) = {
    (for(el <- arr if el > 0) yield el) ++ (for(el <- arr if el < 1) yield el)
  }

  def reorderFilter(arr: Array[Int]) = {
    arr.filter(_ > 0) ++ arr.filter(_ < 1)
  }

  // 5. How do you compute the average of an Array[Double]?
  def avg(arr:Array[Double]) = {
    arr.sum / arr.length
  }

  // 7. Write a code snippet that produces all values from an array with duplicates
  //    removed. (Hint: Look at Scaladoc.)
  def deduplicate[T](arr:Array[T]) = {
    arr.distinct
  }

  // 8. Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on
  //    page 34 using the drop method for dropping the index of the first match. Look
  //    the method up in Scaladoc.
  //    var first = true
  //    var n = a.length
  //    var i = 0
  //    while (i < n) {
  //      if (a(i) >= 0) i += 1
  //      else {
  //        if (first) { first = false; i += 1 }
  //        else { a.remove(i); n -= 1 }
  //      }
  //    }
  def dropFirstNegative(arr: Array[Int]) = {
    val ix = arr.indexWhere(_ < 0)
    for(i <- arr.indices if i != ix) yield arr(i)
  }

//  val arr = Array(10,20,-50,-25,13,45,-11)
//  println(dropFirstNegative(arr).mkString(","))

}
