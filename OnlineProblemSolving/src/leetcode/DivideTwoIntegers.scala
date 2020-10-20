package leetcode

object DivideTwoIntegers {
  // Link to question : https://leetcode.com/problems/divide-two-integers/
  def main(args: Array[String]): Unit = {
    val dividend = -2147483648
    val divisor = -1017100424
    println(s"Result: ${divide(dividend, divisor)}")
  }
  
  def divide(dividend: Int, divisor: Int): Int = {
    // Base case check : If dividend = Int.MinValue
    val flag1 = (dividend == Int.MinValue)
    val flag2 = (divisor == Int.MinValue)

    // Base case check : Divide by zero
    if(divisor == 0)
      return 0
    
    // Base case check : Divide by +/- 1 
    if(divisor == 1)
      return  dividend
    if(divisor == -1){
      if(dividend == Int.MinValue)
        return Int.MaxValue
      else
        return  dividend * (-1)
    }
    
    val multiplier = if(dividend < 0 && divisor < 0) 1 else if(dividend < 0 || divisor < 0) -1 else 1
    val positiveDividend = if(dividend < 0 && flag1 == false) dividend *(-1) else if(dividend < 0 && flag1 == true) Int.MaxValue else  dividend
    val positiveDivisor = if(divisor < 0 && flag2 == false) divisor *(-1) else if(divisor < 0 && flag2 == true) Int.MaxValue else  divisor
    val strDividend = if(dividend == Int.MinValue) "2147483648" else positiveDividend.toString 

    println(s"positiveDividend : ${positiveDividend}, positiveDivsor: ${positiveDivisor} ")
    // Base case check : dividend < divisor
    if(flag1 != true  && flag2 != true && positiveDividend < positiveDivisor)
      return 0
    
    // Base case check : Int.MaxValue / Int.MinValue
    if(dividend == Int.MinValue && divisor == Int.MaxValue)
      return -1
    if(divisor == Int.MinValue && dividend == Int.MaxValue)
      return 0
      
    var i, power = 0
    while(scala.math.pow(10, power) <= positiveDividend)
      power += 1
    power -= 1
    
    var quotient = ""
    var prevNumber : Long = 0
    var remainder = 0
    while(i <= power){
      val tempNumber : Long = (prevNumber * 10 + Integer.parseInt(strDividend(i).toString) )
      println(s"\ncurrent digit: ${Integer.parseInt(strDividend(i).toString)}, tempNumber: ${tempNumber}, positiveDivisor: ${positiveDivisor}")
      if(tempNumber < positiveDivisor){
        println(s"In if...")
        prevNumber = tempNumber
        quotient = quotient + "0"
      }
      else{
        // Divivde
        println(s"In else...")
        var counter = 0
        var tempDivisor = positiveDivisor
        println(s"tempDivisor: ${tempDivisor}, positiveDivisor: ${positiveDivisor}")
        
        import scala.util.control.Breaks._
        breakable{
          while(tempDivisor <= tempNumber){
            if((tempDivisor.toLong + positiveDivisor.toLong) <= Int.MaxValue.toLong){
              println(s"Divisor incremented...")
              tempDivisor += positiveDivisor
              counter += 1
            }
            else{
              counter += 1
              break
            }
          }
        }
        tempDivisor = tempDivisor - positiveDivisor
        quotient = quotient + counter.toString
        prevNumber = if(tempNumber == tempDivisor) 0 else (tempNumber - tempDivisor)
        println(s"TempNumber: ${tempNumber}, TempDivisor: ${tempDivisor}, PositiveDivisor: ${positiveDivisor}, PrevNumber: ${prevNumber}")
        println(s"Temp counter: ${counter}, TempQuotient: ${quotient}")
      }
      // increment the division
      i += 1
    }
    
    quotient.toInt * multiplier
  }
}