package codility

object ReturnArrayWithSumZero {
  def solution(n: Int): Array[Int] = {
    var result = scala.collection.mutable.ArrayBuffer[Int]()
    
    if(n == 0)
      return result.toArray
    if(n == 1)
      return Array(0)
    
    if(n%2 == 0){
      // n is even
      val mid = n/2
      for(i <- 1 to mid){
        result.+=(0 - i)
        result.+=(0 + i)
      }
    }
    else{
      // n is odd
      val mid = (n-1)/2
      result.+=(0)
      for(i <- 1 to mid){
        result.+=(0-i)
        result.+=(0+1)
      }
    }
    result.toArray
  }
  
  def main(args: Array[String]): Unit = {
     val n1 = 3
     val n2 = 4
     
     println(s"${solution(n1).mkString(", ")}")
     println(s"${solution(n2).mkString(", ")}")
     
  }
}