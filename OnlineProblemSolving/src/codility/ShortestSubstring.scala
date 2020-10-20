package codility

object ShortestSubstring {
  def main(args: Array[String]): Unit = {
    val s = "dabbcabbcde"
    println(s"The shortest substring length is: ${shortestSubstring(s)}")
  }
  
  def shortestSubstring(s: String): Int = {
    // Sanity check
    if(s == null || s.isEmpty())
      return 0
    if(s.length == 1)
      return 1
    
    // Executes if string length is more than 1
    
    // Identify all the unique letters
    var charSet = scala.collection.mutable.HashSet[Char]()
    for(char <- s)
      charSet+=(char)
    println(s"${charSet.mkString(", ")}")
    
    // Variable to store the result
    var result = s.length
    var i = 0
    var j = 1
    val n = s.length
    var prevLength = Int.MaxValue
    while(i < n && j < n){
      val tempStr= s.substring(i, j+1)
      
      val currentSizeOfSubStr = tempStr.toCharArray.toSet.size

      // println(s"i: ${i}, j: ${j}, diffCheck: ${(j-i+1) < result}, ${tempStr}, currentSizeOfSubStr: ${currentSizeOfSubStr}, CharSetSize: ${charSet.size}")

      if(currentSizeOfSubStr == charSet.size){
        println(s"First if... ")
        if((j-i+1) < prevLength && currentSizeOfSubStr == charSet.size){
          println(s"Matched")
          result = j-i+1
          prevLength = if(prevLength < (j-i + 1)) prevLength else j-i+1
        }
        j += 1
    		if(j == n){
    			println(s"Here1...")
    			i += 1
    			j = i + 1
    		}
      }else if(j < n){
        j += 1
        if(j == n){
          println(s"Here...")
          i += 1
          j = i + 1
        }
      }else{
        i += 1
        j = i + 1
      }
    } // while loop ends here
    return result
  }
}