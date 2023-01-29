package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26) // the class code block will be evaluated
  // println(person.age): doesn't work as age is not a class member /field, just a param
  // the way to make it a field is to make param a val or a var
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()
}

// constructor
class Person(name: String, val age: Int) {
  // body
  val x = 2 // field

  println(1 + 3)

  // method
  // this key word
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading: function with the same name, but different signatures
  def greet(): Unit = println(s"Hi, I am $name") // will refer to "this".name
  // def greet(): Int = 42 -> greet already defined

  // multiple constructors or overloading constructors
  def this(name: String) = this(name, 0) // secondary constructor calls primary constructor
  // the next constructor must call primary or secondary constructor. Hence overloading constructors
  // are quite limited in usage (only good for adding default params. But one could use default
  // param in the class signature.
}
