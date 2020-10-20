package leetcode

object MedianOfTwoSortedArrays {
  // Link to question: https://leetcode.com/problems/median-of-two-sorted-arrays/
  
  def main(args: Array[String]): Unit = {
    println(findMedianSortedArrays(Array(1,2), Array(3,4)))
  }
  
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    // Merge the sorted arrays
    def merge(a: Array[Int], b: Array[Int]) : Array[Int] = {
      val c: Array[Int] = new Array(a.length + b.length)
      var i, j, k : Int = 0
      
      // Compare and push results
      while(i < a.length && j < b.length){
          if(a(i) < b(j)){
              c(k) = a(i)
              i += 1
          }
          else{
              c(k) = b(j)
              j += 1
          }
          k += 1
      
      }
      // Push the remaining elements 
      while(i < a.length){
          c(k) = a(i)
          k += 1
          i += 1
      }
      // Push the remaining elements 
      while(j < b.length){
          c(k) = b(j)
          k += 1
          j += 1
      }
      c
    }
    
    var result : Array[Int] = merge(nums1, nums2)
    var median = 0.0
    if(result.length %2 == 0){
      // println("Inside if")
      // println(s"${result(result.length/2 - 1)} ${result(result.length/2) }")
      median = (result(result.length/2 - 1) + result(result.length/2) ) / 2.0
    }else{
      // println("Inside else")
      median = result(result.length/2)
    }
    median
  }

}