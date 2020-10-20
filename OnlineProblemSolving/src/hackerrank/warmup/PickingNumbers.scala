package hackerrank.warmup

object PickingNumbers {
  // Write your code here
  def pickingNumbers(a: Array[Int]): Int = {
    var counter, result = 0
    val b = a.sorted
    println(s"Sorted Array: [${b.mkString(", ")}]")
    val diffArray = scala.collection.mutable.ArrayBuffer[Int]()
    for(i <- 1 to b.length-1){
      if(scala.math.abs(b(i) - b(i-1)) <= 1){
        counter += 1
      }
      else{
        counter = 1
      }
      println(s"Elem at ${i}: ${b(i)}, Counter: ${counter}")
      if(counter > result)
        result = counter
    }
    println(s"Final counter: ${counter}")
    return result
  }
  
  def main(args: Array[String]): Unit = {
//    val a = Array(1,1,2,2,4,4,5,5,5)
     val a = Array(4,6,5,3,3,1)
    println(s"Result: ${pickingNumbers(a)}")
  }
}