package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {
  // this class is created inside the object, otherwise
  // it would conflict with the Person class in OOBasics.scala
  class Person(val name: String, favoriteMovie: String, var age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    // the above method name could even be "&" or "+"! Scala is very permissive with the method names
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String) : Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_! : String = s"$name, what the heck?!"// there must be a space before :, otherwise : will be considered as part of the method name
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def learns(subject: String): String = s"$name learns $subject"

    def learnsScala: String = this.learns("Scala") // or this learns "Scala"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // so natural language! Object, method, parameter
  // infix notation = operator notation. Works for methods with a single param. This is an example of syntactic sugar

  // "operators" in Scala
  val tom = new Person("Tom", "Flight Club")
  println(mary hangOutWith tom) // in this case, the method acts like an operator btw Mary & Tom, which yields a string
  println(mary + tom)

  // the following statements are the same
  println(1 + 2)
  println(1.+(2)) // as + is an operator, and a method

  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ? -> don't understand this

  // prefix notation
  val x = -1 // - is unary operator. It's a method too
  val y = 1.unary_- // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  // the functions that do not receive any params can be used in a postfix notation
  println(mary.isAlive)
  println(mary isAlive) // rarely used in practice as the only difference is . and space. In practice, dot is often
  // used as the space notation can introduce ambiguities to people reading the code

  // apply: special method name
  println(mary.apply())
  println(mary()) // apply method defined. Object being called like a function -> use apply
  // this breaks the barrier between OOP & Functional Programming

  /*
  Exercises:
  1) overload the + operator
    mary + "the rockstar" => new person "Mary (the rockstar)" with the same favorite movie
  2) add an age to the person class (with default 0)
    add a unary + operator => new person with age + 1
    +mary => mary with the age increment
  3) add a "learns" method in the Person class. "Mary learns Scala"
    add a learnScala method, no param, calls learns method with "Scala"
    use it in postfix notation
  4) overload the apply method to receive a number and return a string
    mary.apply(2) => "Mary watched Inception 2 times"
   */
  val newMary = mary + "the rockstar"
  println(newMary.name)
  println(newMary likes "Inception")

  val olderMary = +mary
  println(olderMary.age)

  println(mary learns "Scala")
  println(mary learnsScala)

  println(mary(2))
}
