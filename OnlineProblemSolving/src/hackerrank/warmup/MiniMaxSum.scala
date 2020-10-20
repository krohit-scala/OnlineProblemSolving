package hackerrank.warmup

import scala.BigInt

object MiniMaxSum {
  
  // Complete the miniMaxSum function below.
  def miniMaxSum(arr: Array[Int]) {
    val sorterArr = arr.sorted.map(num => BigInt(num))
    val n = arr.length -1
    
    if(arr.length >= 4){
      val minSum : BigInt = sorterArr(0) + sorterArr(1) + sorterArr(2) + sorterArr(3)
      val maxSum : BigInt = sorterArr(n) + sorterArr(n-1) + sorterArr(n-2) + sorterArr(n-3)
      println(s"${minSum} ${maxSum}")
    }
  }
  
  def main(args: Array[String]): Unit = {
    val arr = Array(396285104,573261094,759641832,819230764,364801279)
    miniMaxSum(arr)
  }
}