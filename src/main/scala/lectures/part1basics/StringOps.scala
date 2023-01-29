package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  // the following functions are also present in Java
  println(str.charAt(2))
  println(str.substring(7, 11)) // (inclusive, exclusive)
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  // Scala's own utilities
  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // prepending and appending operators are specific to Scala
  println(str.reverse)
  println(str.take(2))

  // Scala-specific: String interpolators (insert (something of a different nature) into something else.)

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and my age is $age"
  val anotherGreeting = s"Hello, my name is $name and I will turn ${age + 1} next year"
  println(anotherGreeting)

  // F-interpolators (formatting)
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute" // %s: String format; %3d: int; 2 chars minimum, 2 decimal precision
  println(myth)
  // these interpolators could check for type correctness in the values that they expand

  // raw-interpolators
  println(raw"This is a \n new line") // back slashes not escaped
  val escaped = "This is a \n new line"
  println(raw"$escaped")
}
