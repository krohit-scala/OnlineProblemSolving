package leetcode

object RemoveElement {
  // Link to question: https://leetcode.com/problems/remove-element/
  def main(args: Array[String]): Unit = {
    var nums = Array(3,2,2,3)
    val `val` = 3
    val result = removeElement(nums, `val`)
    println(s"Result: ${result}, Modified Array: [${nums.mkString(", ")}]")
  }
  
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    
    // Base case check - 1 : Null or empty input
    if(nums == null && nums.isEmpty)
      return -1
    
    val n = nums.length
    var left, counter = 0
    var right = n - 1
    
    // Base case check - 2 : Size = 1 and element = `val`
    if(n == 1 && nums(0) == `val`)
      return -1

    // Get the elements from the left and swap it with the right
    while(left < right){
      if(nums(left) != `val`){
        left += 1
      }

      if(nums(left) == `val`){
        // Find the element at the right which is not equal to val
        if(nums(right) == `val`){
          right -= 1
        }
        else{
          // Swap the element at the left with the one at the right
          nums(left) = nums(right)
          nums(right) = `val`
          left += 1
          right -= 1
        }
      }
    }
    
    // Count the number of elements matched
    for(i <- n-1 to 0 by -1){
      if(nums(i) == `val`)
        counter += 1
    }

    // Base case check - 3
    if(counter == n){
      // println(s"All elements are equal to: ${`val`}")
      return -1
    }
    
    return (n - counter)
  }
}