package leetcode

object FindTheDuplicateNumber {
  // Link to question: https://leetcode.com/problems/find-the-duplicate-number/
  def main(args: Array[String]): Unit = {
    val arr1 = Array(1,3,4,2,2)
    val arr2 = Array(3,1,3,4,2)
    println(s"Duplicate number in array [${arr1.mkString(", ")}] is: ${findDuplicate(arr1)}")
    println(s"Duplicate number in array [${arr2.mkString(", ")}] is: ${findDuplicate(arr2)}")
  }

  def findDuplicate(nums: Array[Int]): Int = {
    val arr = nums.sorted
    val n = nums.length - 1
    var result = 0
    import scala.util.control.Breaks._
    breakable{
      for(i <- 0 to n){
        if(arr(i) == arr(i+1)){
          result = arr(i)
          break
        }
      }
    }
    return result
  }
}