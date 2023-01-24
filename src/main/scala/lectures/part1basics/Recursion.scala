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
  println(anotherFactorial(5000)) // 0: overflows integer range. everything times 0 will becomes 0 -> use BigInt

  // when you need loops, use tail recursion

  /*
  Exercises:
  1. Concatenate a string n times, tail recursive
  2. isPrime function, tail recursive
  3. fibonacci function, tail recursive
  Any function can be turned into a tail recursive function. The trick is to use accumulator to
    store intermediate results rather than call the function recursively.
    You need as many accumulators as you have recursive calls on your code path.
   */

  /* My solution
  def concatenateString(s: String, n: Int): String = {
    @tailrec
    def helper(s: String, n: Int, accumulator: String): String = {
      if (n == 0) accumulator
      else helper(s, n - 1, s + accumulator)
    }
    helper(s, n, "")
  }
   */

  // Ans
  @tailrec
  def concatenateString(s: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateString(s, n - 1, s + accumulator)

  println(concatenateString("hello", 4, ""))

  /* My ans:
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(x: Int): Boolean = {
      if (x <= 1) true
      else n % x != 0 && isPrimeUntil(x-1)
    }
    isPrimeUntil(n / 2)
  }
   */
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeTailRec(n / 2, isStillPrime = true)
  }
  println(isPrime(2003))
  println(isPrime(24))

  /* My attempt: while thinking I thought of adding ground up
  def fibonacci(n: Int): Int = {
    @tailrec
    def helper(x: Int, accu: Int, otherAccu: Int): Int = {
      if (x <= 2) (accu + otherAccu)
      else helper(x - 1, accu )
    }
    helper(n, 1, 0)
  }
   */
  def fibonacci(n: Int): Int = {
    @tailrec
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i == n) last // i reaches n
      else fiboTailRec(i + 1, last + nextToLast, last)
    }
    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }
  println(fibonacci(6)) // 8
  // fibo(6) = fiboTailRec(2, 1, 1) = fiboTailRect(3, 2, 1) = fiboTailRect(4, 3, 2) = fiboTR(5, 5, 3) = fiboTR(6, 8, 5) = 8
  println(fibonacci(23454))
}

