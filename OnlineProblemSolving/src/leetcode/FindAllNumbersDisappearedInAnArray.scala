package leetcode

object FindAllNumbersDisappearedInAnArray {
  // Link to question: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
  def main(args: Array[String]): Unit = {
    val arr = Array(4,3,2,7,8,2,3,1)
    val arr1 = Array(2,3,4,5,6,7,8,1)
    println(s"${findDisappearedNumbers(arr1)}")
  }
  
  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    val n = nums.length
    var index = 0
    while(index < nums.length){
      if((nums(index) != index+1) && (nums(index) != nums(nums(index)-1) )){
        // Swap the numbers
        val otherIndex = nums(index) -1
        val temp = nums(index)
        nums(index) = nums(otherIndex)
        nums(otherIndex) = temp
      }
      else
        index += 1
    }
    val list = for(index <- nums.indices if nums(index) != index+1) yield index+1
    list.toList
  }
}