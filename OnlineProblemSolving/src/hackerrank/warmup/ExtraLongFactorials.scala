package hackerrank.warmup

import scala.math.BigInt.int2bigInt

object ExtraLongFactorials {
  // Complete the extraLongFactorials function below.
  def extraLongFactorials(n: Int) {
    var result : BigInt = 1

    // Base case check : n = 0 or n = 1
    if(n == 0 || n == 1)
      result = 1
    
    // Base case check : n < 0 
    if(n < 0)
      result = -1
    
    for(i <- 1 to n){
      result *= i
    }
    println(s"${result}")
  }

  
  def main(args: Array[String]): Unit = {
    val num1 = 30
    val num2 = 25
    extraLongFactorials(1)
    extraLongFactorials(num2)
  }
}