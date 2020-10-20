package hackerrank.warmup

object FlatlandSpaceStations {
  
  // Complete the flatlandSpaceStations function below.
  def flatlandSpaceStations1(n: Int, c: Array[Int]): Int = {
    var result = Int.MinValue
    // var arr = new Array[Int](n)
    var arr = c.sorted
    var tempDist = 0
    var prev : Integer = null
    for(elem <- arr){
      prev = if(prev == null) 0 else prev
      tempDist = elem - prev
      if(tempDist > result)
        result = tempDist
      prev = elem
    }

    // Check the first and last cities for Space stations
    var fromStart, fromEnd = 0
    // If first element doesn't have a space station
    if(arr(0) != 0)
      fromStart = scala.math.abs(0 - arr(0))

    // If last element doesn't have a space station
    if(arr(arr.length-1) != n)
      fromEnd = n-1 - arr(arr.length-1)
      
    result = scala.math.max(scala.math.max(fromStart, fromEnd), scala.math.ceil(result/2).toInt)
    result
  }

  // Complete the flatlandSpaceStations function below.
  def flatlandSpaceStations(n: Int, c: Array[Int]): Int = {
    var result = Int.MinValue
    var arr = new Array[Int](n)
    c.foreach(i => {arr(i) = 1})
    
    println(s"[${arr.mkString(", ")}]")
    
    // Expand from the element in both direction
    for(i <- 0 to arr.length-1){
      var j = i+1
      var k = i-1
      var tempDist = 0
      var flag = false
      while(!flag){
        if(arr(i) != 1){
          if(j < n){
            if(arr(j) == 1){
              tempDist = j-i
              flag = true
            }
          }
          if(k >= 0){
            if(arr(k) == 1){
              tempDist = i - k
              flag = true
            }
          }
          j += 1
          k -= 1
        }
        else
          flag = true
      } // while loop ends here
      
      if(tempDist > result)
        result = tempDist
      println(s"i: ${i}, Result: ${result}")
    }
    
    result
  }
  
  def main(args: Array[String]): Unit = {
    val n = 95
    val c = Array(68, 81, 46, 54, 30, 11, 19, 23, 22, 12, 38, 91, 48, 75, 26, 86, 29, 83, 62)
    println(s"${flatlandSpaceStations1(n, c)}")
  }
}