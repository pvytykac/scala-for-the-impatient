package org.pvytykac.sfti

import org.junit.Test
import org.junit.Assert._
import ControlStructuresAndFunctions._

class ControlStructuresAndFunctionsTest {

  // signum1
  @Test
  def testSignum1Positive() {
    assertEquals(1, signum1(10))
  }

  @Test
  def testSignum1Negative() {
    assertEquals(-1, signum1(-10))
  }

  @Test
  def testSignum1Zero() {
    assertEquals(0, signum1(0))
  }

  // signum2
  @Test
  def testSignum2Positive() {
    assertEquals(1, signum2(10))
  }

  @Test
  def testSignum2Negative() {
    assertEquals(-1, signum2(-10))
  }

  @Test
  def testSignum2Zero() {
    assertEquals(0, signum2(0))
  }

  // product
  @Test
  def testProduct() {
    assertEquals(825152896, product("Hello"))
  }

  // recursive product
  @Test
  def testRecProduct() {
    assertEquals(825152896, recProduct("Hello"))
  }

  // x ^ n
  @Test
  def testXn_10_neg3() {
    assertEquals(0.001D, xn(10,-3), Double.MinPositiveValue)
  }

  @Test
  def testXn_10_neg2() {
    assertEquals(0.01D, xn(10,-2), Double.MinPositiveValue)
  }

  @Test
  def testXn_10_neg1() {
    assertEquals(0.1D, xn(10,-1), Double.MinPositiveValue)
  }

  @Test
  def testXn_10_0() {
    assertEquals(1D, xn(10,0), Double.MinPositiveValue)
  }

  @Test
  def testXn_10_2() {
    assertEquals(100D, xn(10,2), Double.MinPositiveValue)
  }

  @Test
  def testXn_10_3() {
    assertEquals(1000D, xn(10,3), Double.MinPositiveValue)
  }

}
