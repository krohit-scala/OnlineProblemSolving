package codility

object CoinFlips {
    def solution(a: Array[Int]): Int = {
    var result = 0
    
    if(a == null || a.isEmpty || a.length == 1)
      return 0
    val n = a.length
    
    val firstNumber = a(0)
    var counter1 = 0

    val secondNumber = a(1)
    var counter2 = 0

    // Starting from the first element
    for(i <- 0 to n-1){
      if(i %2 == 0){
        if(a(i) != firstNumber){
          counter1 += 1
        }
      }
      else{
        if(a(i) == firstNumber){
          counter1 += 1
        }
      }
    }
    
    // Starting from the second element
    for(i <- 0 to n-1){
      if(i %2 == 0){
        if(a(i) == secondNumber){
          counter2 += 1
        }
      }
      else{
        if(a(i) != secondNumber){
          counter2 += 1
        }
      }
    }
    println(s"Array: [${a.mkString(", ")}], Counter1: ${counter1}, Counter2: ${counter2}")
    result = scala.math.min(counter1, counter2)
    result
  }
  
  def main(args: Array[String]): Unit = {
    
    val arr1 = Array(1,0,1,0,1,1)
    val arr2 = Array(0,1,1,0)
    
    println(s"${solution(arr1)}")
    println(s"${solution(arr2)}")
  }
}