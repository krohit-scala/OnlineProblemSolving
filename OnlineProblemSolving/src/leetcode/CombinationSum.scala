package leetcode

object CombinationSum {
  // Link to question: https://leetcode.com/problems/combination-sum/
  def main(args: Array[String]): Unit = {
    val candidates = Array(2,3,6,7)
    val target = 7
    val result = combinationSum(candidates, target)
    for(list <- result)
      println(s"Result contains: [${list.mkString(", ")}]")
  }
  
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    // Base case - 1: Empty input array
    if(candidates == null || candidates.isEmpty || !target.isValidInt)
      return null
    
    
    null
  }
}