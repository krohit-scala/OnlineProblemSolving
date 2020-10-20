package leetcode

object FirstMissingPositive {
  // Link to question: https://leetcode.com/problems/first-missing-positive/
  def main(args: Array[String]): Unit = {
    val arr1 = Array(-1,1000)
    val arr2 = Array(3,4,-1,1)
    val arr3 = Array(7,8,9,11,12)
    
    println(s"[${arr1.mkString(", ")}] gives: ${firstMissingPositive(arr1)}")
//    println(s"[${arr2.mkString(", ")}] gives: ${firstMissingPositive(arr2)}")
//    println(s"[${arr3.mkString(", ")}] gives: ${firstMissingPositive(arr3)}")
  }
  
  def firstMissingPositive(nums: Array[Int]): Int = {
    if(nums == null || nums.isEmpty)
      return 1
      
    val arr = nums.sorted
    val min = arr(0)
    val max = arr(arr.length-1)
    
    var result = 1
    if(max < 0)
      result = 1
    else if(min > 1)
      result = 1
    else if(min == max){
      if(max > 0)
        result = max + 1
      else
        result = 1
    }else{
      import scala.util.control.Breaks._
      breakable{
        // Iterate over the array on the positive side and keep looking for a number which is missing from the array
        var possibleNumber : Integer = 1
        var previousNumber : Integer = null
        for(i <- 0 to arr.length-1){
          if(!(arr(i) <= 0)){
            
            previousNumber = if(i > 0 && arr(i-1) != null) arr(i-1) else 0
            
            if(arr(i) != possibleNumber && arr(i) != previousNumber){
              result = possibleNumber
              break
            }
            else{
              if(! (arr(i) == previousNumber))
                possibleNumber += 1
              previousNumber = arr(i)
            }
            
            // println(s"i: ${i}\tarr(i): ${arr(i)}\tPreviousNumber: ${previousNumber}\tPossibleNumber: ${possibleNumber}")
          }
        } // For loop ends here
        if(result != possibleNumber)
          result = possibleNumber
      } // Breakable ends here
    }
    result
  }
}