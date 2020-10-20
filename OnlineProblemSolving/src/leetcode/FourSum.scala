package leetcode

object FourSum {
  // Link to question: https://leetcode.com/problems/4sum/
  
  def main(args: Array[String]): Unit = {
    val nums = Array(-3,-2,-1,0,0,1,2,3)
    val target = 0
    val result = fourSum(nums, target)
    for(i <- 0 to result.length - 1){
      println(s"Row: ${result(i).mkString(", ")}")
    }
  }
  
  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
    var result : Set[List[Int]] = Set[List[Int]]()
    
    // Base case check
    if(nums == null || nums.isEmpty || nums.length < 4){
      return List[List[Int]]()
    }
    
    val n = nums.length
    val arr = nums.sorted
    println(s"Sorted array: [${arr.mkString(", ")}]")
    for(i <- 0 to n-3){
      for(j <- i+1 to n-2){
        var k = j + 1
        var l = n-1
        
        while(k < l){
          val sum = arr(i) + arr(j) + arr(k) + arr(l)
          // println(s"i: ${i} - ${arr(i)}, j: ${j} - ${arr(j)}, k: ${k} - ${arr(k)}, l: ${l} - ${arr(l)}, Sum: ${sum}")
          if(sum < target){
            k += 1
          }
          else if(sum > target){
            l -= 1
          }
          else{
            // println(s"Quadruplet found: [${arr(i)}, ${arr(j)}, ${arr(k)}, ${arr(l)}]")
            val tempResult = List(arr(i),arr(j),arr(k),arr(l))
            result = result.+(tempResult)
            k += 1
            l -= 1
          }
        }
      }
    }
    result.toList
  }
}