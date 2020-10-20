package leetcode

object LongestPalindromicSubstring {
  // Link to question: https://leetcode.com/problems/longest-palindromic-substring/
  
  def main(args: Array[String]): Unit = {
    var str1 = "Banana"
    var str2 = "ABCDEFEDCBA"
    println(s"Longest palindrome in ${str1}: ${getLongestPalindrome(str1)}")
    println(s"Longest palindrome in ${str2}: ${getLongestPalindrome(str2)}")
  }
  
  def expand(str: String, start1: Integer, end1: Integer) : String = {
		  var start = start1
		  var end = end1
      while(start >= 0 && end <= str.length - 1 && str(start) == str(end)) {
			  start -= 1
			  end += 1
		  }
		  return str.substring(start+1, end)
  }
  
  def getLongestPalindrome(str: String) : String = {
    var result = ""
    if(!str.isEmpty && str.length <= 1)
      result = str
    else{
      var longest = ""
      for(i <- 0 to str.length - 1){
        var temp = expand(str, i, i)
        if(temp.length > longest.length)
          longest = temp
        
        temp = expand(str, i, i+1)
        if(temp.length > longest.length)
          longest = temp
      }
      result = longest
    }
    result
  }
  
}