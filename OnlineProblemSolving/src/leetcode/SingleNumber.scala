package leetcode

object SingleNumber {
  // Link to question: https://leetcode.com/problems/single-number/
  def main(args: Array[String]): Unit = {
    val arr1 = Array(2,2,1)
    val arr2 = Array(4,1,2,1,2)
    val arr3 = Array(1,3,1,-1,3)
    println(s"Number occuring only once in [${arr1.mkString(", ")}]: ${singleNumber(arr1)}")
    println(s"Number occuring only once in [${arr2.mkString(", ")}]: ${singleNumber(arr2)}")
    println(s"Number occuring only once in [${arr3.mkString(", ")}]: ${singleNumber(arr3)}")
  }
  
  def singleNumber(nums: Array[Int]): Int = {
    val arr = nums.sorted
    // println(s"Array sorted: [${arr.mkString(", ")}]")
    var result : Integer = null
    import scala.util.control.Breaks._
    breakable{
      for(i <- 0 to arr.length-2 by 2){
        if(arr(i) != arr(i+1)){
          result = arr(i)
          break
        }
      }
    }
    if(result == null)
      result = arr(arr.length-1)
    result
  }
}