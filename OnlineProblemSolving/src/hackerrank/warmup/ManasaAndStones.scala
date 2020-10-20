package hackerrank.warmup

object ManasaAndStones {
  
  // Complete the stones function below.
  def stones(n: Int, a: Int, b: Int): String = {
    val min = scala.math.min(a, b)
    val max = scala.math.max(a, b)
    
    var current = min * (n-1)
    val maxStoneNum = max * (n-1)
    
    if(current - maxStoneNum == 0)
      return current.toString
    else{
      var result = "" // scala.collection.mutable.ArrayBuffer[Int]()
      while(current <= maxStoneNum){
        result = result + (if(result.isEmpty) "" else " ") + s" ${current}"
        current += (max-min)
      }
      return result
    }
  }
  
  def main(args: Array[String]): Unit = {
    val n = 4
    val a = 10 
    val b = 100
    println(s"${stones(n, a, b)}")
  }
}