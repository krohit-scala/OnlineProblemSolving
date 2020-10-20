package hackerrank.warmup

object BirthdayChocolate {
  def birthday(s: Array[Int], d: Int, m: Int): Int = {
    // Base case check - 1 : If array is null or empty
    if(s == null || s.isEmpty)
      return 0
    
    // Base case check - 2 : Month number is greater than array length
    if(s.length < m)
      return 0
    
    val n = s.length
    var i, j, count = 0
    for(i <- 0 to n - m){
      var tempSum = 0
      j = 0
      while(j < m){
        tempSum += s(i+j)
        j += 1
      }
      if(tempSum == d)
        count += 1
    }
    count
  }
  
  def main(args: Array[String]): Unit = {
    val s1 = Array(1,2,1,3,2)
    val d1 = 3
    val m1 = 2
    println(s"No of ways: ${birthday(s1, d1, m1)}")
    val s2 = Array(1,1,1,1,1,1)
    val d2 = 3
    val m2 = 2
    println(s"No of ways: ${birthday(s2, d2, m2)}")    
  }
}