package leetcode

object LetterCombinationsOfAPhoneNumber {
  // Link to question: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
  def main(args: Array[String]): Unit = {
    val digits = "234"
    println(s"All possible combinations: [${letterCombinations(digits).mkString(", ")}]")
  }
  
  // 100% Correct : Better than 94.92% of Scala online submissions
  def letterCombinations(digits: String): List[String] = {
    // This will hold final results
    var buffer = scala.collection.mutable.ArrayBuffer[String]()

    if(digits == null || digits.isEmpty)
      return buffer.toList
    
    // Store digit vs string mapping
    val map = Map(
                "2" -> "abc", 
                "3" -> "def",
                "4" -> "ghi",
                "5" -> "jkl",
                "6" -> "mno",
                "7" -> "pqrs",
                "8" -> "tuv",
                "9" -> "wxyz"
              )
    // If the input has just one digit
    if(digits.length == 1){
      buffer ++= map(digits).toCharArray.map(_.toString)
      return buffer.toList
    }
    
    // For more than one digits in the input
    // -------------------------------------
    def joinStringCombinations(buffer: scala.collection.mutable.ArrayBuffer[String], s2: String) : Unit ={
      var tempBuffer = scala.collection.mutable.ArrayBuffer[String]()
      for(i <- 0 to buffer.length-1){
        for(j <- 0 to s2.length -1){
          tempBuffer.append(buffer(i).toString + s2(j).toString)
        }
      }
      buffer.clear
      buffer ++= (tempBuffer)
    }
    
    var i = 0
    while(i < digits.length ){
      if(i == 0)
        buffer ++= map(digits(0).toString).toCharArray.map(_.toString)
      else{
        val s2 = map(digits(i).toString)
        joinStringCombinations(buffer, s2)
      }
      i += 1
    }
    
    buffer.toList
  }
  
  // Not 100% correct
  def letterCombinations1(digits: String): List[String] = {
    // This will hold temporary results
    val buffer = scala.collection.mutable.ArrayBuffer[String]()

    if(digits == null || digits.isEmpty)
      return buffer.toList
    
    // Store digit vs string mapping
    val map = Map(
                "2" -> "abc", 
                "3" -> "def",
                "4" -> "ghi",
                "5" -> "jkl",
                "6" -> "mno",
                "7" -> "pqrs",
                "8" -> "tuv",
                "9" -> "wxyz"
              )

    if(digits.length == 1){
      buffer ++= map(digits).toCharArray.map(_.toString)
      return buffer.toList
    }
    
    // This will join all combinations of the characters in both the strings
    def joinStringCombinations(s1: String, s2: String) : Unit ={
      for(i <- 0 to s1.length-1){
        for(j <- 0 to s2.length -1){
          buffer.append(s1(i).toString + s2(j).toString)
        }
      }
    }
    var i = 0
    var currentString : String = null
    while(i < digits.length - 1){
      currentString = if(currentString == null) map(digits(i).toString) else currentString 
      val nextString = map(digits(i+1).toString)
      joinStringCombinations(currentString, nextString)
      currentString = currentString + nextString
      i += 2
    }
    buffer.toList
  }
}