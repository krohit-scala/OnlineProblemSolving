package leetcode

object LongestSubstringWithoutRepeatingCharacters {
  // Link to question: https://leetcode.com/problems/longest-substring-without-repeating-characters/
  
  def main(args: Array[String]): Unit = {
    val str = "abcabcbb"
    println(s"Longest length of a substring in '${str}' is: ${lengthOfLongestSubstring(str)}.")
  }
  
  // Time complexity is n
  def lengthOfLongestSubstring(str: String): Int = {
    var i, j, maxLen = 0
    var charSet = scala.collection.mutable.HashSet[Char]()
    
    while(i < str.length && j < str.length){
      if(! charSet.contains(str(j).toChar)){
        charSet += str(j).toChar
        j += 1
        maxLen = scala.math.max(maxLen, j-i)
      }
      else{
        charSet.remove(str(i).toChar)
        i += 1
      }
      // println(s"CharSet: ${charSet.mkString(" , ")}; maxLen = ${maxLen}; j-i = ${j-i}")
    }
    maxLen
  }
  
  // Time complexity - n^2. Not efficient!
  /*
  def lengthOfLongestSubstring(str: String): Int = {
    import scala.util.control.Breaks
    
    val breaker = new Breaks
    var maxLen = 0
    
    for(i <- 0 until str.length){
      var charSet = new scala.collection.mutable.HashSet[String]()
      var lenCounter = 0
      
      // Checking for substring i-th position onwards
      breaker.breakable{
      for(j <- i until str.length){
        // println(s"Current character: ${str(j)}")
        if(! charSet.contains(str(j).toString) ){
          charSet += str(j).toString
          lenCounter += 1
          }
           else{
            charSet.empty
            maxLen = if(lenCounter > maxLen) lenCounter else maxLen
            breaker.break
          }
          // println(s"Current character: ${str(j)}, LenCounter = ${lenCounter}, MaxLen = ${maxLen}.")
        }
        maxLen = if(lenCounter > maxLen) lenCounter else maxLen
      }
    }
    maxLen
  } */
}