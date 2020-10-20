package leetcode

object MoveZeroes {
  // Link to quesiton: https://leetcode.com/problems/move-zeroes/
  
  def main(args: Array[String]): Unit = {
    val nums = Array(1,0)
    moveZeroes(nums)
    println(s"Modified Array: [${nums.mkString(", ")}]")
  }
  
  def moveZeroes(nums: Array[Int]): Unit = {
    // Base check - 1
    if(nums == null || nums.isEmpty)
      return 
		
	  val n = nums.length
	  var nonZeroCount = 0
	  
	  for(i <- 0 to n-1){
		  if(nums(i) != 0){
			  nonZeroCount += 1
			  // Swap elements
			  if(i != nonZeroCount -1){
			    nums(nonZeroCount -1) = nums(i)
				  nums(i) = 0
			  }
		  }
	  } // Loop ends here
  }
}