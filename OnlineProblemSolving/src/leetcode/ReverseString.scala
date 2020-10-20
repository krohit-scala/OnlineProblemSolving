package leetcode

object ReverseString {
  // Link to question: https://leetcode.com/problems/reverse-string/
  def main(args: Array[String]): Unit = {
//    val str = "aidnI gnisiR"
//    reverseString(str)
    val s = Array('h','e','l','l','o')
    reverseString(s)
  }
  
  def reverseString(str: String) : Unit = {
    if(str.length > 1){
      reverseString(str.substring(1, str.length))
      println(str(0))
    }
    else{
      println(str)
    }
  }
  
  def reverseString(s: Array[Char]) : Unit = {
    var i = 0
    var j = s.length - 1
    
    while(i <= j){
      var temp = s(i)
      s(i) = s(j)
      s(j) = temp
      
      i += 1
      j -= 1
    }
    println(s"Reverse String: ${s.mkString}")
  }
}