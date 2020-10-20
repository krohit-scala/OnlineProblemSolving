package leetcode

object RegularExpressionMatching {
  // Link to question: https://leetcode.com/problems/regular-expression-matching/
  def main(args: Array[String]): Unit = {
    println(s"${isMatch("aa", "a")}")  // false
    println(s"${isMatch("aa", "a*")}") // true
    println(s"${isMatch("ab", ".*")}") // true
    println(s"${isMatch("aab", "c*a*b")}")  // true
    println(s"${isMatch("mississippi", "mis*is*p*.")}") // false
  }
  
  def isMatch(s: String, p: String): Boolean = {
    
    if(p.equals("*"))
      return true
    if(p.equals(".") && s.length == 1)
      return true
    if(p.equals(".") && s.length > 1)
      return false
    
    false
  }
}