package lectures.part1basics

object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = { // Long: time functions in Scala and on the JVM return Longs
    println("By value: " + x)
    println("By value: " + x)
  }
  // By value: 12506508875700
  // By value: 12506508875700

  def calledByName(x: => Long): Unit = { // => tells the compiler the params will be called by name
    println("By name: " + x)
    println("By name: " + x)
  }
  // By name: 12506572702000
  // By name: 12506572766300

  calledByValue(System.nanoTime()) // param is evaluated before the function call, then value used throughout the function
  calledByName(System.nanoTime()) // as if the following, x gets replaced by param (param passed literally, i.e. as is),
  // evaluation delayed (only at every USE within the function definition):
  /*
  def calledByName(x: => Long): Unit = { // => tells the compiler the params will be called by name
    println("By name: " + System.nanoTime())
    println("By name: " + System.nanoTime())
  }
   */

  /*
  CBN is extremely useful in lazy streams and in things that might fail.
  That's what we are going to study when we look at the try type.
   */

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

  // printFirst(infinite(), 34) // stack overflow
  printFirst(34, infinite())
  // can run because the by name parameter y in printFirst delays the evaluation of the expression passed (i.e. infinite())
  // until it's used. Since y is never used in printFirst, infinite() was never evaluated -> printFirst can finish running
}
