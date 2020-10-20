package leetcode

object ContainerWithMostWater {
  // Link to question: https://leetcode.com/problems/container-with-most-water/
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,4,3)
    println(s"Max water contained is: ${maxArea1(arr)}")
  }
  
  def maxArea(arr: Array[Int]): Int = {
    var result = 0
    if(arr  == null || arr.length < 2)
      return 0
    
    val n = arr.length
    var maxL, maxR = 0
    var maxLIndex, maxRIndex = 0
    
    for(i <- 0 to (n-1)/2){
      if(arr(i) > math.min(maxL, maxR) && i < (n-1 -i)){
        if(arr(i) > maxL){
          maxL = arr(i)
          maxLIndex = i
        }
        if(arr(n-1 -i) > maxR){
        	maxR = arr(n-1 -i)
        	maxRIndex = n-1 -i
        }
      }
    }
    // println(s"MaxL: ${maxL}, MaxR: ${maxR}, MaxLIndex: ${maxLIndex}, MaxRIndex: ${maxRIndex}")
    result = math.min(maxL, maxR) * math.abs(maxLIndex - maxRIndex)
    result
  }
  
  def maxArea1(arr: Array[Int]): Int = {
    var maxArea = 0
    if(arr  == null || arr.length < 2)
      return 0
    
    val n = arr.length
//    var maxL, maxR = 0
    var left = 0
    var right = n -1
    
    while(left < right){
      maxArea = math.max(maxArea, math.min(arr(left), arr(right)) * (right - left))
      if(arr(left) < arr(right))
        left += 1
      else
        right -=1
    }
    maxArea
    // println(s"MaxL: ${maxL}, MaxR: ${maxR}, MaxLIndex: ${maxLIndex}, MaxRIndex: ${maxRIndex}")
  }
}