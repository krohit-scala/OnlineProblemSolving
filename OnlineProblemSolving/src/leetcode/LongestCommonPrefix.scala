package leetcode

// import scala.util.control.Breaks

object LongestCommonPrefix {
  // Link to question: https://leetcode.com/problems/longest-common-prefix/
  def main(args: Array[String]): Unit = {
    val strs : Array[String] = Array("c", "c")
    println(s"Longest common Prefix is: ${longestCommonPrefix(strs)}")
  }
  
  
  def longestCommonPrefix(strs: Array[String]): String = {
    if(strs == null || strs.isEmpty || strs.length == 0)
      return ""
    if(strs != null && strs.length == 1)
      return strs(0)
      
    var result = ""
    var strRange = Int.MaxValue
    
    // Find the length of smallest string in the array
    for(i <- strs.indices){
      if(strs(i).length < strRange)
        strRange = strs(i).length
    }
    val effRange = strRange -1
    println(s"StrRange: ${strRange}")
    var counter = 0
    
    // Brute force approach
    
    import scala.util.control.Breaks._
    breakable{
      while(strRange > 0 && counter <= effRange){
        var currentChar : Character = strs(0)(counter)
        if(!strs(0).isEmpty()){
          //breakable{
            for(i <- strs.indices){
              println(s"i: ${i}, Counter: ${counter}, strRange: ${strRange} CurrentCharacter: ${currentChar}")
              if(strs(i)(counter) != currentChar){
                currentChar = null
                break
              }
            }
            counter += 1
//          }
        }
      }
    }
    result += strs(0).substring(0, counter)
    result
  }
}