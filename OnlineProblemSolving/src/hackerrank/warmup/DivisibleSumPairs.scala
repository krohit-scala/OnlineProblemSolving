package hackerrank.warmup

object DivisibleSumPairs {
  
  // Complete the divisibleSumPairs function below.
  def divisibleSumPairs(n: Int, k: Int, ar: Array[Int]): Int = {
    // Base case check - 1 : Null or empty array
    if(ar == null || ar.isEmpty)
      return 0
    
    // Base case check - 2 : Array size != n
    if(ar.length != n)
      return 0
    
    var count = 0
    for(i <- 0 to n-1){
      for(j <- i+1 to n-1){
        if((ar(i) + ar(j)) % k == 0)
          count += 1
      }
    }
    count
  }
  
  def main(args: Array[String]): Unit = {
    val ar = Array(1,3,2,6,1,2)
    val n = ar.length
    val k = 3
    println(s"${divisibleSumPairs(n, k, ar)}")
  }
}