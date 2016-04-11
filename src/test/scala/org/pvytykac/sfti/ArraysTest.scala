package org.pvytykac.sfti

import org.junit.Test
import org.junit.Assert._

class ArraysTest {

  // randomArr
  @Test
  def testRandomArr10() {
    testRandomArrN(10)
  }

  @Test
  def testRandomArr25() {
    testRandomArrN(25)
  }

  private def testRandomArrN(n: Int) {
    val arr = Arrays.randomArr(n)

    assertEquals(n, arr.length)
    assertEquals(n, arr.count(x => x >= 0 && x < n))
  }

  // swapAdjecent
  @Test
  def testMoveSwapAdjacentPatternMatch() {
    testMoveSwap(Array(1,2,3,4,5), Array(2,1,4,3,5), Arrays.moveSwapAdjacentPatternMatch[Int])
  }

  @Test
  def testSwapAdjacentPatternMatchString() {
    testMoveSwap(Array('a','b','c','d','e'), Array('b','a','d','c','e'), Arrays.moveSwapAdjacentPatternMatch[Char])
  }

  @Test
  def testMoveSwapAdjacentFor() {
    testMoveSwap(Array(1,2,3,4,5), Array(2,1,4,3,5), Arrays.moveSwapAdjacentFor[Int])
  }

  @Test
  def testMoveSwapAdjacentForString() {
    testMoveSwap(Array('a','b','c','d','e'), Array('b','a','d','c','e'), Arrays.moveSwapAdjacentFor[Char])
  }

  @Test
  def testCopySwapAdjacentFlatMap() {
    testCopySwap(Array(1,2,3,4,5), Array(2,1,4,3,5), Arrays.copySwapAdjacentFlatMap)
  }

  @Test
  def testCopySwapAdjacentPatternMatch() {
    testCopySwap(Array(1,2,3,4,5), Array(2,1,4,3,5), Arrays.copySwapAdjacentPatternMatch)
  }

  @Test
  def testCopySwapAdjacentPatternMatchString() {
    testCopySwap(Array('a','b','c','d','e'), Array('b','a','d','c','e'), Arrays.copySwapAdjacentPatternMatch)
  }

  def testMoveSwap[T](original: Array[T], expected: Array[T], f:(Array[T] => Unit)) {
    f(original)
    for((a,b) <- expected.zip(original)) assertEquals(a,b)
  }

  def testCopySwap(original: Array[Double], expected: Array[Double], f:(Array[Double] => Array[Double])) {
    val result = f(original)
    for((a,b) <- expected.zip(result)) assertEquals(a,b,Double.MinValue)
  }

  // reorded
  @Test
  def testReorderFor() {
    val arr = Array(5,7,4,-3,2,15,0,-10)
    val reordered = Arrays.reorderFor(arr)
    val expected = Array(5,7,4,2,15,-3,0,-10)

    for((a,b) <- expected.zip(reordered)) assertEquals(a,b)
  }

  @Test
  def testReorderFilter() {
    val arr = Array(5,7,4,-3,2,15,0,-10)
    val reordered = Arrays.reorderFilter(arr)
    val expected = Array(5,7,4,2,15,-3,0,-10)

    for((a,b) <- expected.zip(reordered)) assertEquals(a,b)
  }

  // avg
  @Test
  def testAvg0() {
    val arr = Array(-10D, 10D)
    assertEquals(0, Arrays.avg(arr), Double.MinValue)
  }

  @Test
  def testAvg20() {
    val arr = Array(-10D, 60D, 10D)
    assertEquals(20, Arrays.avg(arr), Double.MinValue)
  }

  // dedup
  @Test
  def testDeduplicate() {
    val arr = Array(1,1,1,2,2,2,3,3,3,4,4,4)
    val deduped = Arrays.deduplicate(arr)

    for(v <- arr.distinct) assertEquals(1, deduped.count(_ == v))
  }

  // dropFirstNegative
  @Test
  def testDropFirstNegative1() {
    val arr = Array(1,2,3,4,-5,-4,1,2,3,4)
    val expected = Array(1,2,3,4,-4,1,2,3,4)
    val result = Arrays.dropFirstNegative(arr)

    for((a,b) <- expected.zip(result)) assertEquals(a, b)
  }

  @Test
  def testDropFirstNegative2() {
    val arr = Array(1,2,3,4,-4,-5,1,2,3,4)
    val expected = Array(1,2,3,4,-5,1,2,3,4)
    val result = Arrays.dropFirstNegative(arr)

    for((a,b) <- expected.zip(result)) assertEquals(a, b)
  }
}
