package leetcode

object MissingNumber {
  // Link to question: https://leetcode.com/problems/missing-number/
  def main(args: Array[String]): Unit = {
    
  }
  
  def missingNumber(nums: Array[Int]): Int = {
    val n = nums.length
    val expectedSum = (n*(n+1)) /2
    var actualSum = 0
    for(num <- nums){
      actualSum += num
    }
    return expectedSum - actualSum
  }
}