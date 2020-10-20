package leetcode

object FindTheDifference {
  // Link to question: https://leetcode.com/problems/find-the-difference/
  def main(args: Array[String]): Unit = {
    val s = "abcd"
    val t = "eabdc"
    println(s"Extra charater is in '${s}' vs '${t}' is: ${findTheDifference(s, t)}")
  }
  
  def findTheDifference(s: String, t: String): Char = {
    val arr1 = s.toCharArray.sorted
    val arr2 = t.toCharArray.sorted

    for(i <- 0 to s.length - 1){
      if(!arr1(i).equals(arr2(i))){
        return arr2(i)
      }
    } // for loop ends here
    
    arr2(arr2.length -1)
  }  
}