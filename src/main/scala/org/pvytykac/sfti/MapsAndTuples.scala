package org.pvytykac.sfti

import scala.collection.mutable
import scala.collection.immutable
import scala.io.Source

object MapsAndTuples extends App {

  // 1. Set up a map of prices for a number of gizmos that you covet. Then produce
  //    a second map with the same keys and the prices at a 10 percent discount.
  val prices = Map("A" -> 25D, "B" -> 120D, "C" -> 99.99D)
  val discounted = for((k, v) <- prices) yield (k, v * 0.9D)

  // 2. Write a program that reads words from a file. Use a mutable map to count
  //    how often each word appears. To read the words, simply use a java.util.Scanner:
  //
  //    val in = new java.util.Scanner(java.io.File("myfile.txt"))
  //    while (in.hasNext()) process in.next()
  //
  //    Or look at Chapter 9 for a Scalaesque way.
  //    At the end, print out all words and their counts.
  def countWordsMutable(file: String) = {
    val words = Source.fromFile(file, "UTF8").mkString.split("""[\s\.,-]+""")
    val wordMap = new mutable.HashMap[String, Int]()
    words.distinct.foreach(word => wordMap(word) = words.count(_ == word))

    wordMap
  }
  println(countWordsMutable("src\\test\\resources\\lorem-ipsum.txt"))

  // 3. Repeat the preceding exercise with an immutable map.
  def countWordsImmutable(file: String) = {
    val words = Source.fromFile(file, "UTF8").mkString.split("""[\s\.,-]+""")
    val wordCounts = for(word <- words.distinct) yield (word, words.count(_ == word))

    immutable.Map[String, Int](wordCounts: _*)
  }
  println(countWordsImmutable("src\\test\\resources\\lorem-ipsum.txt"))

  // 4. Repeat the preceding exercise with a sorted map, so that the words are
  //    printed in sorted order.
  def countWordsImmutableSorted(file: String) = {
    val words = Source.fromFile(file, "UTF8").mkString.split("""[\s\.,-]+""")
    val wordCounts = for(word <- words.distinct) yield (word, words.count(_ == word))

    immutable.SortedMap(wordCounts: _*)
  }
  println(countWordsImmutableSorted("src\\test\\resources\\lorem-ipsum.txt"))

  // 5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the
  //    Scala API.
  //    TODO: skipped

  // 6. Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and
  //    similarly for the other weekdays. Demonstrate that the elements are visited
  //    in insertion order.

  // 7. Print a table of all Java properties, like this:
  //    java.runtime.name     | Java(TM) SE Runtime Environment
  //    sun.boot.library.path | /home/apps/jdk1.6.0_21/jre/lib/i386
  //    java.vm.version       | 17.0-b16
  //    java.vm.vendor        | Sun Microsystems Inc.
  //    java.vendor.url       | http://java.sun.com/
  //    path.separator        | :
  //    java.vm.name          | Java HotSpot(TM) Server VM
  def printProperties() {
    import scala.collection.JavaConversions.propertiesAsScalaMap

    val map: scala.collection.Map[String, String] = System.getProperties
    val maxLen = map.keySet.toArray.sortWith(_.length > _.length).head.length

    for((k,v) <- map) printf("%s | %s\n", k + (" " * (maxLen - k.length)), v)
  }
  printProperties()

  // 8. Write a function minmax(values: Array[Int]) that returns a pair containing the
  //    smallest and largest values in the array.
  def minmax(arr: Array[Int]) = {
    (arr.min, arr.max)
  }
  println(minmax(Array(1,2,3,4,5,6)))

  // 9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing
  //    the counts of values less than v, equal to v, and greater than v.
  def lteqgt(arr: Array[Int], v: Int) = {
    (arr.count(_ < v), arr.count(_ == v), arr.count(_ > v))
  }
  println(lteqgt(Array(0 to 10: _*), 5))

  // 10. What happens when you zip together two strings, such as "Hello".zip("World")?
  //     Come up with a plausible use case.
  def dif(first: String, second: String) = {
    val zipped = first.zip(second)
    for(ix <- zipped.indices if zipped(ix)._1 != zipped(ix)._2) yield (ix, zipped(ix)._1, zipped(ix)._2)
  }
  println(dif("abcdefgh", "abcdeFgh"))
}
