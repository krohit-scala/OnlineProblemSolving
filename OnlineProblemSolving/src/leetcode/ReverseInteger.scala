package leetcode

object ReverseInteger {
  // Link to question: https://leetcode.com/problems/reverse-integer/
  def main(args: Array[String]): Unit = {
    println(s"Reverse of 0: ${reverse(-2147483648)}")
  }
  
  def reverse(x: Int): Int = {
    if(x == null || x >= Int.MaxValue || x <= Int.MinValue)
      return 0
     
    var num = x
    var multiplier = 1
    var numBuff = ""
    
    if(x < 0) {
      multiplier = -1
      num *= -1
    }
    var counter = 0
    while(num >= 10){
      numBuff += (num%10)
      num = num / 10
    }
    if(num >= 0 && num < 10)
      numBuff  += (num)
    
    var result : Long = (numBuff).toLong * multiplier
    if(result <= Int.MaxValue && result >= Int.MinValue) result.toInt else 0
  }
}