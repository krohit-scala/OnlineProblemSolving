package leetcode

object StringToIntegerAtoi {
  // Link to question: https://leetcode.com/problems/string-to-integer-atoi/
  def main(args: Array[String]): Unit = {
    println(s"Result: ${myAtoi("  word  +32.000000001234567")}")
  }
  
  def myAtoi(str: String): Int = {
    if(str == null || str.isEmpty || str.length == 0)
      return 0

    // To store the results
    var result = 0
    
    // Find index till first non white-space character
    var isSequenceStarted = false
    var index = 0
    while(isSequenceStarted == false && index < str.length){
      if(!str(index).equals(' '))
        isSequenceStarted = true
      else{
        index += 1
      }
    }
    println(s"Sequence starts from index: ${index}")

    if(isSequenceStarted){
      // Check if negative/positive sign is specified
      var multiplier = 1
  
      if(str(index).equals('-') || str(index).equals('+')){
        if(str(index).equals('-')){
          multiplier = -1
          index += 1
        }
        else if(str(index).equals('+')){
          multiplier = 1
          index += 1
        }
      }
  
      import scala.util.control.Breaks._
      
      var parsesdNumber = ""
      breakable {
        for(i <- index to str.length - 1){
          if(str(i).equals(' ') || !str(i).isDigit){
            break
          }
          if(str(i).isDigit)
            parsesdNumber += str(i)
          
        } // for loop ends here
      } // Breakable ends here
      
      if(parsesdNumber == null || parsesdNumber.isEmpty){
        result = 0
      }
      else{
          // var res : BigInt = BigInt(parsesdNumber) * multiplier
          var res : Long = (parsesdNumber).toLong * multiplier
          result = if(res <= Int.MaxValue && res >= Int.MinValue) 
                     res.toInt 
                   else{ 
                     if(multiplier == -1){
                       Int.MinValue
                     }
                     else
                       Int.MaxValue
                   } // result assignment ends here
      }
    } // Outernost if ends here
    result
  }
}