package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  /*
  JVM uses a call stack to keep partial results so that it can get
  back to computing the desired result.
  Each call of the recursive function uses a stack frame.
  */

  def newFactorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * newFactorial(n - 1) // not tail recursion as it's not the last expression
      println("Computing factorial of " + n)

      result
    }
  }
  println(newFactorial(10))
  // The trouble with this approach is that JVM keeps all the calls in its internal stack
  // which has limited memory
  // println(newFactorial(5000)) // StackOverFlowError

  def anotherFactorial(n: Int): BigInt = {
    @tailrec // tell compiler that this function should be tail recursive. If add this to the prev one, there will be an error
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // Tail recursion
    }
    factHelper(n, 1)
  }
  println(anotherFactorial(5000)) // 0: overflows integer range. everything times 0 will becomes 0

  // when you need loops, use tail recursion

  /*
  Exercises:
  1. Concatenate a string n times
  2. isPrime function tail recursive
  3. fibonacci function tail recursive
  Any function can be turned into a tail recursive function. The trick is to use accumulator to
    store intermediate results rather than call the function recursively.
    You need as many accumulators as you have recursive calls on your code path.
   */

//  def concatenateString(s: String, n: Int): String = {
//
//  }
}

