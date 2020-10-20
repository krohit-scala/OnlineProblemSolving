package hackerrank.warmup

object LeftRotation {
  
  // Complete the rotLeft function below.  
  def rotLeft(a: Array[Int], d: Int): Array[Int] = {
    // Base case check - 1 : Null/empty array
    if(a == null || a.isEmpty)
      return null
    
    // Base case check 2 : No of rotation is multiple of array length
    val n = a.length
    if(d%n == 0)
      return a
    
    // Finding effective rotaion
    val effectiveRotation = if(d > n) d % n else d
    var counter = 0
    var result = scala.collection.mutable.ArrayBuffer[Int]()
    
    // Shifting last n - counter elements
    for(i <- effectiveRotation to n-1)
      result += a(i)
    
    // Shifting the starting elements
    for(i <- 0 to effectiveRotation -1)
      result += a(i)
    
    result.toArray
  }
  
  def main(args: Array[String]): Unit = {
    val a = Array(1,2,3,4,5)
    val d = 2
    println(s"Result array: [${rotLeft(a, d).mkString(", ")}]")
  }
}