package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26) // the class code block will be evaluated
  // println(person.age): doesn't work as age is not a class member /field, just a param
  // the way to make it a field is to make param a val or a var
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  // test exercises
  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expecations", 1861, author)

  println(novel.authorAge) // syntax allowed for param-less methods
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new CounterWithSideEffect
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print
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

/*
Novel & Writer class
Writer: first name, surname, year
  - method: full name
Novel: name, year of release, author
  - authorAge (at the year of release)
  - isWrittenBy(author): if the novel is written by author
  - copy (new year of release) = new instance of Novel with a new year of release
 */

/* my solution
class Writer(firstName: String, surname: String, year: Int) {
  val birthYear: Int = year

  def fullName(): String = {
    this.firstName + this.surname
  }
}
 */

// ans
class Writer(firstName: String, surname: String, val year: Int) {
  def fullName = firstName + " "+ surname // notice that there is no () for params. No "this" either
}


class Novel(name: String, yearOfRelease: Int, val author: Writer) {
  def authorAge: Int = yearOfRelease - author.year

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}

/*
Counter class
  - receive an int value
  - method: current count
  - method: increment / decrement -> new Counter
  - overload inc/dec to receive an amount -> new Counter
 */

class Counter(val count: Int) { // with val, a getter isn't needed any more
  def increment: Counter = new Counter(count + 1) // immutability. instances are fixed, cannot be modified inside
  // whenever content needs modification, a new instance is returned. V important concept

  def decrement: Counter = new Counter(count - 1)

  def increment(amount: Int): Counter = new Counter(count + amount)

  def decrement(amount: Int): Counter = new Counter(count - amount)
}

class CounterWithSideEffect(val count: Int = 0) { // with val, a getter isn't needed any more
  def increment: CounterWithSideEffect = {
    println("Incrementing")
    new CounterWithSideEffect(count + 1)
  }

  def decrement: CounterWithSideEffect = {
    println("Decrementing")
    new CounterWithSideEffect(count - 1)
  }

  def increment(amount: Int): CounterWithSideEffect = {
    if (amount <= 0) this
    else increment.increment(amount - 1) // increment method returns a new instance -> this instance calls increment(amount - 1)
  }

  def decrement(amount: Int): CounterWithSideEffect = {
    if (amount <= 0) this
    else decrement.decrement(amount - 1)
  }

  def print = println(count)
}