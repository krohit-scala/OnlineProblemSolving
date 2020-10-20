package hackerrank.warmup

object BeautifulTriplets {
  
  // Complete the beautifulTriplets function below.
  def beautifulTriplets(d: Int, arr: Array[Int]): Int = {
    var result = 0
    val n = arr.length -1
    for(i <- 0 to n-2){
      for(j <- i+1 to n-1){
        if(arr(j) - arr(i) == d){
          for(k <- j+1 to n){
            if(arr(k) - arr(j) == d)
              result += 1
          }
        }
      }
    }
    result
  }
  
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,4,5,7,8,10)
    val d = 3
    println(s"${beautifulTriplets(d, arr)}")
  }
}