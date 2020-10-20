package leetcode

object ThreeSumClosest {
  // Link to question: https://leetcode.com/problems/3sum-closest/
  def main(args: Array[String]): Unit = {
    val nums = Array(0,1,2)
    val target = 3
    println(s"Closest sum to target(${target}) is: ${threeSumClosest1(nums, target)}")
  }

  def threeSumClosest1(nums: Array[Int], target: Int): Int = {
    var minDiff = Int.MaxValue
    var minDiffSum = 0
    val arr = nums.sorted
    
    for(i <- 0 to arr.length -2){
      var left = i + 1
      var right = arr.length -1
      
      while(left < right){
        val sum = arr(i) + arr(left) + arr(right)
        val currDiff = scala.math.abs(target - sum)

        // val str = s"a: ${arr(i)}, b: ${arr(left)}, c: ${arr(right)}, i: ${i}, Left: ${left}, Right: ${right}"
        // println(s"${str} -- Target: ${target}, Sum: ${sum}, Diff: ${closest}, GlobalMin: ${minClosest}")
        
        if(sum == target){
          return sum
        }else if(sum < target){
          left += 1
        }else{
          right -= 1
        }
        
        if(currDiff < minDiff){
          minDiff = currDiff
          minDiffSum = sum
        }
      }
    }
    minDiffSum
  }
}