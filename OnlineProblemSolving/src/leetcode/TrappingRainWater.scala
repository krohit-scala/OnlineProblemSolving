package leetcode

object TrappingRainWater {
  // Link to question: https://leetcode.com/problems/trapping-rain-water/
  def main(args: Array[String]): Unit = {
    val arr1 = Array[Int](0,1,0,2,1,0,1,3,2,1,2,1)
    println(s"Amount of ran water trapped: ${trap(arr1)}")
  }
  
  def trapNotWorking(arr: Array[Int]): Int = {
    var left, right = 0
    var result = 0
    var temp = 0
    
    while(left < arr.length && right < arr.length){
      
      var message = s"Left: ${left}, Right: ${right}, Arr(left): ${arr(left)}, Arr(right): ${arr(right)}"
      if(left == right)
        right += 1
      else{
        if(arr(right) >= arr(left)){
          left = right
          result += temp
          temp = 0
        }
        else{
          temp = temp + (if(arr(left) >= arr(right)) {arr(left) - arr(right)} else 0)
          right += 1
        }
      }
      println(s"${message}, Result: ${result}")
    }
    result
  }
  
  def trap(arr: Array[Int]) : Int = {
    var result = 0
    var n = arr.length
    if(n == 0)
      return 0
      
    var maxOfLeftTillIndex : Array[Int] = Array.fill(n){0}
    var maxOfRightTillIndex : Array[Int] = Array.fill(n){0}
    
    for(i <- 1 to n-1){
      val j = n-1 -i
      maxOfLeftTillIndex(i) = scala.math.max(arr(i-1), maxOfLeftTillIndex(i-1))
      maxOfRightTillIndex(j) = scala.math.max(arr(j+1), maxOfRightTillIndex(j+1))
    }
    
    for(i <- 0 to n-1){
      var effHeight = scala.math.min(maxOfLeftTillIndex(i), maxOfRightTillIndex(i))
      if(effHeight > arr(i))
        result += effHeight - arr(i)
    }
    result
  }
}