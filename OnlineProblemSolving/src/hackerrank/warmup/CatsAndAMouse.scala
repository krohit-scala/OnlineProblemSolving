package hackerrank.warmup

object CatsAndAMouse {
  
  // Complete the catAndMouse function below.
  def catAndMouse(x: Int, y: Int, z: Int): String = {
    println(s"${scala.math.abs(x-z)}")
    println(s"${scala.math.abs(y-z)}")
    if(scala.math.abs(x-z) == scala.math.abs(y-z))
      "Mouse C"
    else if(scala.math.abs(x-z) < scala.math.abs(y-z))
      "Cat A"
    else
      "Cat B"
  }

  
  def main(args: Array[String]): Unit = {
//    val x = 1
//    val y = 2
//    val z = 3
    val x = 1
    val y = 3
    val z = 2
    println(s"Result: ${catAndMouse(x, y, z)}")
  }
}