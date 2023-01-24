package lectures.part1basics

object ValueVariableTypes extends App {
  val x: Int = 42
  println(x)

  // x = 42
  // val creates an immutable variable (like final in Java)

  // val x = 42
  // compilers can infer types of val when omitted

  val aString: String = "Hello"

  // ; is needed if multiple lines are in single line (bad style)

  val aBoolean: Boolean = true
  var aChar: Char = 'A'
  val anInt: Int = x
  val aShort: Short = 4616 // int type, but 2 bytes. int: 4 bytes
  val aLong: Long = 3849238497987987987L // int type, but 8 bytes
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 42
  aVariable = 5  // var are mutable. In functional programming, vars are used for side effects
  aVariable += 1
  // side effects are useful as they show what program is doing

  // Func programming is about using less variables. Prefer vals (values) over vars (variables)
}