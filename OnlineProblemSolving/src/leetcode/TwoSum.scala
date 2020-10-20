package leetcode

object TwoSum {
    // Link to question: https://leetcode.com/problems/two-sum/
  
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var result = new Array[Int](2)
        var numMap = new scala.collection.mutable.HashMap[Int, Int]()
        for(j <- nums.indices) { numMap.put(nums(j), j)}
        for(i <- nums.indices){
          if( (numMap.contains(target - nums(i)) ) && (i != numMap(target - nums(i)) )){
            result(0) = i
            result(1) = numMap(target - nums(i))
          } 
        }
        result
    }
    def main(args: Array[String]): Unit = {
      val nums = Array(3,2,4)
      val target = 6
      var res = twoSum(nums, target)
      println(s"[${res(0)}, ${res(1)}]")
    }
}