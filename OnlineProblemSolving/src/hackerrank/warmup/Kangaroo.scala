package hackerrank.warmup

object Kangaroo {
  
  // Complete the kangaroo function below.
  def kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String = {
    // Base case check - 1 : In sync jumps with constant distance
    if(v1 == v2 && x1 != x2)
      return "NO"
    
    // Base case check -2 : One is leading the other
    if(v2 > v1 && x2 >= x1)
      return "NO"
    if(v1 > v2 && x1 >= x2)
      return "NO"
    
    val relativeSpeed = scala.math.abs(v1 - v2)
    val relativeDistance = scala.math.abs(x2 - x1)
    var flag = true
    var counter : Long = 0
    var d1 = x1
    var d2 = x2
    while(flag && counter <= Int.MaxValue){
      if(x1 + v1*counter == x2 + v2*counter){
        flag = false
      }
      else{
        counter += 1
      }
    }
    if(!flag){
      println(s"No of jumps: ${counter}")
      return "YES"
    }
    else
    "NO"
  }
  
  def main(args: Array[String]): Unit = {
//    val x1 = 0
//    val v1 = 3
//    val x2 = 4
//    val v2 = 2 //21 6 47 3
    val x1 = 21
    val v1 = 6
    val x2 = 47
    val v2 = 3
    println(s"${kangaroo(x1, v1, x2, v2)}")
  }
}