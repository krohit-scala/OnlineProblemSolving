package hackerrank.warmup

object FindDigits {
  
  // Complete the findDigits function below.
  def findDigits(n: Int): Int = {
    var result = 0
    
    // Base case check - 1 : If n = 0
    if(n == 0)
      return 0
    
    var num = n
    while(num > 0){
      val digit = num%10
      if(digit != 0 && n%digit == 0)
        result += 1
      
      num = num/10
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val n1 = 12
    val n2 = 1012
    println(s"${findDigits(n1)}")
    println(s"${findDigits(n2)}")
  }
}