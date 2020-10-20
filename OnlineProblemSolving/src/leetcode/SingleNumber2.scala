package leetcode

object SingleNumber2 {
  // Link to question: https://leetcode.com/problems/single-number-ii/
  def main(args: Array[String]): Unit = {
    val arr1 = Array(2,2,3,2)
    val arr2 = Array(0,1,0,1,0,1,-99)
    
    val arr3 = Array(43,16,45,89,45,
                    -2147483648,45,2147483646,-2147483647,
                    -2147483648,43,2147483647,-2147483646,
                    -2147483648,89,-2147483646,
                    89,-2147483646,-2147483647,2147483646,
                    -2147483647,16,16,2147483646,43)
    println(s"Answer is: ${singleNumber(arr3)}")
  }
  
  // Time complexity: O(n*log(n))
  def singleNumber(nums: Array[Int]): Int = {
    val arr = nums.sorted
    println(s"${arr.mkString(", ")}")
    for(i <- 0 to arr.length -3 by 3){
      if(!(arr(i) == arr(i+1) && arr(i) == arr(i+2)))
        return arr(i)
    }
    arr(arr.length -1)
  }
  
  // Time complexity: O(n)
  def singleNumber1(nums: Array[Int]): Int = {
    var result: Integer = null
    var sumArr : Long = 0
    var set = scala.collection.mutable.HashSet[Int]()
    for(num <- nums){
      sumArr += num
      set += num
    }
    val sumSet : Long = set.sum
    println(s"SumArr: ${sumArr}, SumSet: ${sumSet * 3}, Diff: ${(sumSet * 3) - sumArr}")
    val diff = ((sumSet * 3) - sumArr)/2
    diff.toInt
  }
  
}