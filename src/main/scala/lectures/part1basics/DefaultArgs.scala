package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  @tailrec
  def trFactorial(n: Int, acc: Int = 1): Int = {
    if (n == 1) acc
    else trFactorial(n - 1, acc * n)
  }
  /*
   Notice that every time we call the above function, acc will need to be 1
   acc pollutes the function signature because we're only interested in n
   acc is only a technicality that allows us to write the tail recursive function
   -> Scala allows us to specify a default value at the parameter level (=1).
   */
  val fac10 = trFactorial(10)
  println(fac10)

  val woDefault = trFactorial(10, 2)
  println(woDefault)

  /*
  problem with default args: compiler will be confused if the arg could not be matched easily to param
   */
  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture")
  // savePicture(800) <- compiler doesn't know which param 800 stands for

  /*
  2 solutions
  1. pass in every leading args: savePicture("jpg", 800)
  2. name the argument: savePicture(width = 800)
   */

  // with named argument, you could pass in args in different order
  savePicture(width = 200, height = 400, format = "jpg")

}
