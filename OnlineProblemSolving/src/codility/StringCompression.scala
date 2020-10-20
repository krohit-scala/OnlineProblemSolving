package codility

object StringCompression {
  
  def solution(s : String) : String = {
    var result = ""
    
    // Base case : s is empty
    if(s == null || s.isEmpty)
      return result
    else if(s.length > 0){
      // Scan the string letter by letter.
      // If current character and its next character are AB, BA, CD or DC, remove them,
      // and call the recursive function with the remaining string
      for(i <- 0 to s.length-2){
        val currChar = s(i)
        val nextChar = s(i+1)
        val cond1 = if( ( (currChar.equals('A') && nextChar.equals('B') ) ) || (currChar.equals('B') && nextChar.equals('A')) ) true else false
        val cond2 = if( ( (currChar.equals('C') && nextChar.equals('D') ) ) || (currChar.equals('D') && nextChar.equals('C')) ) true else false
        
        if(cond1 || cond2){
          val nextIndex = if(i+2 <= s.length -1) i+2 else 0
          val part1 = s.substring(0, i)
          val part2 = (if(nextIndex != 0) s.substring(i+2, s.length) else "")
          val nextString = part1 + part2

          // println(s"Part1: ${part1}\t Part2: ${part2}")
          // println(s"String for next pass: ${nextString}")
          
          if(nextString.length > 1){
            val tempResult = solution(nextString)
            result = result + tempResult
            return result
          }
          return nextString
        } // If condition ends here
      } // For loop ends here
    } // Outermost else ends here
    
    result = s
    result
  }
  
  def main(args: Array[String]): Unit = {
    val s1 = "CBACD"
    val s2 = "CABABD"
    val s3 = "ACBDACBD"
    
    println(s"\nOutput for [${s1}] is: ${solution(s1)}")
    println(s"\nOutput for [${s2}] is: ${solution(s2)}")
    println(s"\nOutput for [${s3}] is: ${solution(s3)}")
    
  }
}