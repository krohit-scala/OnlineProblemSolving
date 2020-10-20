package leetcode

import scala.collection.immutable.HashSet
import scala.util.control.Breaks
import scala.collection.mutable.ArrayBuffer
import scala.collection.Set

object ThreeSum {
  // Link to question: https://leetcode.com/problems/3sum/
  def main(args: Array[String]): Unit = {
    val nums = Array(-1,0,1,0)
    val nums1 = Array(-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0)
    println(s"Output for this array is: ${threeSum(nums).mkString(", ")}")
    println(s"Output for this array is: ${threeSum(nums1).mkString(", ")}")
  }
  
  def threeSum(nums : Array[Int]) : List[List[Int]] = {
    if(nums == null || nums.isEmpty || nums.length < 3)
      return List[List[Int]]()
    
    var result = List[List[Int]]()
    
    val len = nums.length
    val arr = nums.sorted
    println(s"${arr.mkString(", ")}")
    
    for(i <- 0 to len-2){
      var j = i + 1
      var k = len -1
      while(j < k){
        val sum = arr(i) + arr(j) + arr(k)
        
        if(sum < 0){
          // increment the left index
          j += 1
        }
        else if(sum > 0){
          // decrement the right index
          k -= 1
        }
        else{
          // triplet found, add that to list
          val tempList = List(arr(i), arr(j), arr(k))
          result = result.::(tempList)
          j += 1
          k -= 1
        }
      } // Inner loop ends here
    } // Outer loop ends here
    return result.distinct
  }
}