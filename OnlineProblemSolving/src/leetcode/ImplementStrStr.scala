package leetcode

object ImplementStrStr {
  // Link to question: https://leetcode.com/problems/implement-strstr/
  def main(args: Array[String]): Unit = {
    var h = "a"
    var n = "a"
    println(s"Index of ${n} in ${h}: ${strStr(h, n)}")
    h = "aaaaa"
    n = "bba"
//    println(s"Index of ${n} in ${h}: ${strStr(h, n)}")
    
  }
  
  def strStr(haystack: String, needle: String): Int = {
    // Sanity checks - 1
//    if(haystack == null || haystack.isEmpty)
//      return -1
    // Sanity check - 2
    if(needle == null || needle.isEmpty)
      return 0
    
    
    val indexList = for(i <- 0 to (haystack.length - needle.length) if(haystack(i) == needle(0))) yield i
    println(s"Indices: ${indexList.mkString(", ")}")
    
    for(index <- indexList){
      if(index + needle.length <= haystack.length){
//        println("Here...")
//        println(s"Substring: ${haystack.substring(index, index + needle.length)}")
        if(needle.equals(haystack.substring(index, index + needle.length)))
          return index
      }
    }
    // Needle not found in haystack
    return -1
  }
}