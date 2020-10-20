package leetcode

object PalindromeNumber {
  // Link to question: https://leetcode.com/problems/palindrome-number/

  def isPalindrome(x: Int): Boolean = {
	  var str = x.toString
	  var result = true
	  var i = 0
	  var j = str.length -1

	  while(i <= j){
		  if(!str(i).equals(str(j)))
			  result = false
			i += 1
			j -= 1
	  }
	  result
  }
}