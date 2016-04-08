package org.pvytykac.sfti

import org.slf4j.LoggerFactory

object ControlStructuresAndFunctions extends App {

  // 1. The signum of a number is 1 if the number is positive, –1 if it is negative, and
  //    0 if it is zero. Write a function that computes this value.
  //
  // failed attempts at generics :(
  // def signum3[T: Numeric](n: T)(implicit num: Numeric[T]): Int = ???
  // def signum4[T](n: T)(implicit num: Numeric[T]): Int = ???
  // def signum5(n: Either[Int,Long,Float,Double]): Int = ???
  // def signum6[T >: Either[Int,Long,Float,Double]](n: Ordered[T]): Int = if( n < 0 ) -1 else if ( n > 0 ) 1 else 0
  def signum1(n: Double): Int = n.compare(0)
  def signum2(n: Double): Int = if (n < 0) -1 else if (n > 0) 1 else 0

  // 4. Write a Scala equivalent for the Java loop
  //    for (int i = 10; i >= 0; i--) System.out.println(i);
  println("4: ")
  (0 to 10).reverse.foreach(println(_))

  // 5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.
  def countdown(n: Int) { (0 to n).reverse.foreach(println(_)) }
  println("5: ")
  countdown(13)

  // 6. Write a for loop for computing the product of the Unicode codes of all letters
  //    in a string. For example, the product of the characters in "Hello" is 825152896.
  println("6: " + (for(c <- "Hello") yield c.toInt).product)

  //  7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps
  //     Scaladoc.)
  println("7: " + "Hello".foldLeft(1)(_ * _.toInt))

  // 8. Write a function product(s : String) that computes the product, as described
  //    in the preceding exercises
  def product(str: String) = str.foldLeft(1)(_ * _.toInt)

  // 9. Make the function of the preceding exercise a recursive function.
  def recProduct(str: String): Int = {
    val head = str.head.toInt
    if( str.tail.isEmpty ) head else head * recProduct(str.tail)
  }

  // 10. Write a function that computes xn, where n is an integer. Use the following
  //     recursive definition:
  //     • x ^ n = y ^ 2 if n is even and positive, where y = x ^ (n / 2).
  //     • x ^ n = x * x ^ (n – 1) if n is odd and positive.
  //     • x ^ 0 = 1.
  //     • x ^ n = 1 / x ^ (–n) if n is negative.
  //     Don’t use a return statement.
  def xn(x:Int, n: Int): Double = {
    import math.pow

    n match {
      case c if c % 2 == 0 && c > 0 => pow( xn(x, n / 2 ), 2)
      case c if c % 2 != 0 && c > 0 => x * xn(x, n - 1 )
      case c if c < 0 => 1 / xn(x, -n)
      case 0 => 1
    }
  }
}
