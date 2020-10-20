package hackerrank.warmup

object BirthdayCakeCandles {
   
  // Complete the birthdayCakeCandles function below.
  def birthdayCakeCandles(ar: Array[Int]): Int = {
    var max = 0
    var count = 0
    for(i <- 0 to ar.length-1){
      if(ar(i) > max){
        println(s"New max found...")
        max = ar(i)
        count = 1
      }
      else if(ar(i) == max){
        println(s"Max count incremented...")
        count += 1
      }
    }
    count
  }
  
  def main(args: Array[String]): Unit = {
    val arr = Array(3,1,2,3)
    println(s"Result: ${birthdayCakeCandles(arr)}")
  }
}