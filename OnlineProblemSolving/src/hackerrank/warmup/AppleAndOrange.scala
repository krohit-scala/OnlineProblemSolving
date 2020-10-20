package hackerrank.warmup

object AppleAndOrange {
  
  // Complete the countApplesAndOranges function below.
  def countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array[Int], oranges: Array[Int]) {
    // Counting apples
    var appleCount, orangeCount = 0
    for(i <- 0 to apples.length -1){
      if(a + apples(i) >= s && a + apples(i) <= t)
        appleCount += 1
    }
    
    // Counting oranges
    for(i <- 0 to oranges.length -1){
      if(b + oranges(i) >= s && b + oranges(i) <= t)
        orangeCount += 1
    }
    
    println(s"${appleCount}\n${orangeCount}")
  }
  
  def main(args: Array[String]): Unit = {
    val s = 7
    val t = 11
    val a = 5
    val b = 15
    val apples = Array(-2, 2, 1)
    val oranges = Array(5,-6)
    
    countApplesAndOranges(s, t, a, b, apples, oranges)
  }
}