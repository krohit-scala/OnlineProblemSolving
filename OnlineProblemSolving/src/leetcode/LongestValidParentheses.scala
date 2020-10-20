package leetcode

object LongestValidParentheses {
  // Link to question: https://leetcode.com/problems/longest-valid-parentheses/
  def main(args: Array[String]): Unit = {
      val s = "())()()(())((()(()()(((()))((((())((()(())()())(()((((()))()(()))(())()(())(()(((((())((((((()())())(()(()((())()))(()))))))()(()))((((())()()()))()()()(((()(()())(()()(()(()()(((()))))))()()))())())((()()))))))((()))(((()((())()(()()))((())))()()())))))))()))))(()))))()))()))()((())))((()))(()))))))(((()))))))))()(()()()(())((())()))()()(())))()()))(()())()))(((()())()))((())((((()))(()(()(()()()(((())()(((((()))((()(((((())(()()))((((((((()(()(()(()(())))(())(()())())(()((((()(())((()(())))(())))()(((((()(()()(())))))))())(())(())(()()(((())))((()))(((((()))))())))()((()))()))))())))))((())(((((()()))((((())))(((()(()(())())(((()(()(()()()())))())()))((()((())())()()()(((())(((((()((((((()((()())))((((())((()(((((((()(()((()()()(()(()())(()(()()((((())))()(((()())))(()()))()(()()()()(((((())(()))))((()))())))()((((((()))())))()(()))(())))((((()())(((((()()())(((((())(()())(()))))()(()()))()))))))())))(((())(()(()()))(()))()(((())))())((((()(((()))))))()(()(()))()()(()()))))))))((()))))))(())((()((()))()))((((((()())))))(()((())((((()))))(()(()()()()(()))()()(()(()))(()()(((((((()())(())(()())((())())()(()())((())()())())(()())))())))(())())())(())((()())(((()()))()))()()))()(()(())((((((((())))()((())((()((((((((((()))))(()(((((())(()(()())())))((())())))))()))(()((()()))((()((())()()()((()(())())((())())(()()(((())))))())()()(()))()())(()(()((())))((((()()(())))())(())(()(()(())())())(()()())()(())())))(()()(((())))((()()(((())()()(()())((((()()(()())(()((((()(()()(()(()(((()((()())(()()))(()((((()(((((()))))()()))(((()((((((()(()()()()())()))(()(())))))((()(((()())())))(((()()))(()(()(((((((()()))(()(())))())()(())())(())(()))(())(()))()()(()()())))))()))()((())(((()((((((((())()()))())))((()())("
      val s1 = "((()"
      println(s"Result is: ${longestValidParentheses(s1)}")
      println(s"Result is: ${longestValidParentheses(s)}")
  }
  
  def longestValidParentheses(s: String): Int = {
    // To be used as the data structure for validating the parenthesis
    var stack = scala.collection.mutable.Stack[Int]()
    // To store the indices around which the parenthesis is balanced
    var strBuff = s.toCharArray
    
    val n = s.length
    
    for(i <- 0 to n-1){
      val c = s(i)
      if(c == '(')
        stack.push(i)
      else{
        if(!stack.isEmpty){
          stack.pop
        }
        else{
          // list.append(i)
          strBuff(i) = '#'
        }
      }
    } // for loop ends here
    
    while(!stack.isEmpty){
      strBuff(stack.pop) = '#'
    }
    
    // list = list.sorted
    var l, r, maxLen = 0
    while(r < strBuff.length){
      if(strBuff(r) == '#'){
        while(r < strBuff.length && strBuff(r) == '#'){
          r += 1 
        }
        l = r
      }
      else if(r + 1 < strBuff.length && strBuff(r+1) == '#'){
        maxLen = scala.math.max(maxLen, r - l + 1)
        l = r + 2
        r = r + 2
      }else{
        r += 1
      }
    }
    if(r >= strBuff.length)
      r = strBuff.length
    maxLen = scala.math.max(maxLen, r-l)
    maxLen
  }
  
  // Brute force: highly unoptimized solution
  def longestValidParentheses1(s: String): Int = {
    if(s.length < 2)
      return 0
    
    // Logic to validate a parentheses
    def isValid(s: String): Boolean = {
      var result = false
      var stack = scala.collection.mutable.Stack[Char]()
      
      var startSet = scala.collection.immutable.HashSet[Char]('(', '{', '[')
      // var endSet = scala.collection.immutable.HashSet[Char](')', '}', ']')
      
      var startCounter, endCounter = 0
      var map = Map(('(' -> ')'), ('{' -> '}'), ('[' -> ']'))
      
      for(i <- 0 to s.length -1){
        if(startSet.contains(s(i))){
          stack.push(s(i))
          startCounter += 1
        }
        else{
          endCounter += 1
          if(!stack.isEmpty && s(i) == map(stack.top)){
            stack.pop
          }
        }
      }
      
      // Check if the stack is empty
      if(startCounter == endCounter && stack.isEmpty)
        result = true
      // Return the output
      result
    }
    
    // Initialize two pointers to traverse through the string
    // Initialize a maxLength variable to store the result
    var l =0
    var r = 1
    var maxLength = 0

    while(l < r && r < s.length){
      val tempStr = s.substring(l, r+1)
      println(s"Left: ${l}, Right: ${r}, SubString: ${s.substring(l, r+1)}")
      if(isValid(tempStr)){
        // println("Valid")
        if(maxLength < tempStr.length)
          maxLength = tempStr.length
        
        r += 1
      }else if(r != s.length -1){
        // println("Invalid")
        r += 1
      }else{
        l += 1
        r = l+1
      }
    }
    
    maxLength
  }
}