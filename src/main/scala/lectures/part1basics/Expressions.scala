package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // an expression
  println(x)

  println(3 + 4 * 2)
  // math operators: + - * /. bit-wise: &, |, <<, >>, ^, >>> (right shift with zero extension, specific to Scala only)

  println(x == 1)
  println(!(x==1))
  // logical operators: ==, !=, >, >=, <, <=, ! (negation), &&, ||

  var aVariable = 2
  aVariable += 3 // also works for -=, *=, /=
  println(aVariable) // changing a variable (reassignment) is called side effect

  /*
   distinctions between Instructions (i.e. statements) and Expressions
   Instructions (do). Java, Python. Always telling computer to do something
   Expression (value). In Scala or functional programming in general, we think in expressions
      every single bit of your code will compute a value
   Everything in Scala is an expression! (except for definitions of val, val, class etc.)
   Instructions are executed, expressions are evaluated
  */

  // IF expression
  val aCondition = true
  val aConditionedVal = if(aCondition) 5 else 3 // not an IF instruction
  println(aConditionedVal)
  println(if(aCondition) 5 else 3)

  // there are loops in Scala, but not encouraged to use (DO NOT USE Whiles!) as they are like imperative language like Java
  // they don't return meaningful stuff, only execute side effects
  // while loop in Scala:
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS
  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  var aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  // Side effects in Scala are expressions that return Unit
  // side effects examples: println(), while, reassigning

  // code blocks
  var aCodeBlock = { // this code block is an expression. The value of the code block is the value of its last expression
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "bye" // makes code block has type String
  }
  // things declared inside the code block is only visible inside


  /*
   Exercises
   1. Differences between "hello" and println("hello")?
      ans: the latter is a side effect but not the former (one of the difference)
      ans given: "hello" is a value of type string. The latter: an expression which is a side effect
        so they have different types: String, Unit (2nd difference)
   2. what's the value of: true, 234 -> correct!
   */
  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if (someValue) 234 else 986
    // 42 -> if this line is evaluated, then someOtherValue = 42
  }
  println(someOtherValue)
}
