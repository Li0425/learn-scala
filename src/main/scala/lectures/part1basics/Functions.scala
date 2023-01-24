package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {
  def aFunction(a: String, b: Int): String =
    a + " " + b
  println(aFunction("hello", 3))

  def aFunctionWithCodeBlock(a: String, b: Int): String = {
    a + " " + b
  }
  /*
   the return type could be inferred by compiler too. It's optional to specify it
   but recursive functions need a result type. Compiler cannot figure that out.
     this is because when compiler evaluates the recursive part, it tries to know the return type
     of the function itself, which is not known in the first place & it's the target finding -> infinite loop
   best practice: always specify return type
   */

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)  // this only works in Scala 2
  // Scala 3 forbids the mix-up: functions with parentheses must be called with parentheses, without must be called without

  def aRepeatedFunction(aString: String, n:Int): String = {
    if (n==1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("hello", 3))
  // WHEN YOU NEED LOOPS, USE RECURSION. This is a fundamental idea of functional programming

  // If the function only execute side effects, return Unit
  def aFunctionWithSideEffect(a: String): Unit = {
    println(a)
  }
  aFunctionWithSideEffect("hey")

  // one can define auxiliary function inside a function
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  /*
    1. A greeting function (name, age) => "Hi, my name is <>, and I am <> years old"
    2. Factorial function 1 * 2 * 3 * ... * n
    3. Fibonacci function: f(1)=1, f(2)=1, f(n)=f(n-1)+f(n-2)
    4. Test if a number is prime
   */
  def greeting(name: String, age: Int): String = {
    "Hi, my name is " + name + ", and I am " + age + " years old."
  }
  println(greeting("Alice", 27))

  def factorial(n: Int): Int = {
    if (n==1) 1 // if (n <= 1) 1
    else n * factorial(n-1)
  }
  println(factorial(5)) // should be 120

  def fibonacci(n: Int): Int = {
    if (n==1 || n==2) 1 // if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }
  println(fibonacci(4)) // should be 3

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean = { // evaluates from n/2 to 1 descending
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
      // for a composite number n, n & t will have remainder 0, else expression evaluates to false, function return false (not prime)
    }
    isPrimeUntil(n / 2) // all divisors of n are <= n/2 as the smallest divisor is 2
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(27*13))
}
