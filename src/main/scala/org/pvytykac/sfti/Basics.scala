package org.pvytykac.sfti

object Basics extends App {

  {
    // 2. In the Scala REPL, compute the square root of 3, and then square that value.
    //    By how much does the result differ from 3? (Hint: The res variables are your
    //    friend.)
    import math.{pow, sqrt}

    println("2: " + pow(sqrt(3), 2))
  }

  {
    // 4.Scala lets you multiply a string with a number—try out "crazy" * 3 in the REPL.
    //   What does this operation do? Where can you find it in Scaladoc?

    println("4: "+ ("crazy" * 3))
  }

  {
    // 5. What does 10 max 2 mean? In which class is the max method defined?

    println("5: " + (10 max 2))
  }

  {
    // 6. Using BigInt, compute 2^1024
    import math.BigInt

    println("6: " + BigInt(2).pow(1024))
  }

  {
    // 7. What do you need to import so that you can get a random prime as
    //    probablePrime(100, Random), without any qualifiers before probablePrime and Random?
    import math.BigInt.probablePrime, util.Random

    println("7: " + probablePrime(100, Random))
  }

  {
    // 8. One way to create random file or directory names is to produce a random
    //    BigInt and convert it to base 36, yielding a string such as "qsnvbevtomcj38o06kul".
    //    Poke around Scaladoc to find a way of doing this in Scala
    import math.BigInt, util.Random

    println("8: " + BigInt(100, Random).toString(36))
  }

  {
    // 9. How do you get the first character of a string in Scala? The last character?
    val str = "abcdefgh"

    // first
    println("9aa: " + str.head)
    println("9ab: " + str.take(1))
    println("9ac: " + str.dropRight(str.length - 1))
    println("9ad: " + str.substring(0, 1))

    // last
    println("9ba: " + str.last)
    println("9bb: " + str.takeRight(1))
    println("9bc: " + str.drop(str.length - 1))
    println("9bd: " + str.substring(str.length - 1))

  }




}
