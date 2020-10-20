package leetcode

object RemoveDuplicatesFromSortedArray {
  // Link to question: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
  def main(args: Array[String]): Unit = {
    val nums1 = Array(1,1,2)
    println(s"Result is: ${removeDuplicates(nums1)}")
    val nums2 = Array(0,0,1,1,1,2,2,3,3,4)
    println(s"Result is: ${removeDuplicates(nums2)}")
  }
  
  def removeDuplicates(nums: Array[Int]): Int = {
    var previousNumber : Int = Int.MinValue
    var pointer = 0
    
    for(i <- 0 to nums.length - 1){
      //println(s"Previous Number: ${if(previousNumber == null) "NaN" else previousNumber}")
      if((nums(i) != previousNumber)){
        previousNumber = nums(i)
        nums(pointer) = nums(i)
        pointer += 1
      }
    }
    //println(nums.mkString(", "))
    pointer
  }
}