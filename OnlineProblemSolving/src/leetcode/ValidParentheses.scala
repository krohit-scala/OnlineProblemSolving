package leetcode

object ValidParentheses {
  // Link to question: https://leetcode.com/problems/valid-parentheses/
  def main(args: Array[String]): Unit = {
    val s1 = ")"
    val s2 = "()[]{}"
    val s3 = "(]"
    val s4 = "([)]"
    val s5 = "{[]}"
    
    println(s"Is ${s1} Valid: ${isValid(s1)}")
    println(s"Is ${s2} Valid: ${isValid(s2)}")
    println(s"Is ${s3} Valid: ${isValid(s3)}")
    println(s"Is ${s4} Valid: ${isValid(s4)}")
    println(s"Is ${s5} Valid: ${isValid(s5)}")
  }
  
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
}