package hackerrank.warmup

object SaveThePrisoner {
  // Complete the saveThePrisoner function below.
  def saveThePrisoner(n: Int, m: Int, s: Int): Int = {
    val last = ((m - 1) + (s - 1)) % n + 1
    return last
  }
  
  def main(args: Array[String]): Unit = {
    
  }
}