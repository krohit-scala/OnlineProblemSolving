package hackerrank.warmup

object TwoDArrayDS {

  // Complete the hourglassSum function below.
  def hourglassSum(arr: Array[Array[Int]]): Int = {
    // Base case check - 1: Empty Array
    if(arr == null || arr.isEmpty)
      return 0
    for(arr1 <- arr){
      if(arr1 == null || arr.isEmpty)
        return 0
    }
    
    var result : Int = Int.MinValue

    for(i <- 0 to arr.length-1){
    }
    var i, j, k = 0
    while(i < 4){
      j = 0
      while(j <4){
        // Hourglass sum at A(i,j)
        val tempSum = (arr(i)(j) + arr(i)(j+1) + arr(i)(j+2) 
                      + arr(i+1)(j+1) 
                      + arr(i+2)(j) + arr(i+2)(j+1) + arr(i+2)(j+2)) 
        println(s"Tempsum: ${tempSum}")
        if(tempSum > result)
          result = tempSum
        k += 1
        j += 1
      }
      i += 1
    }
    result
  }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn
        val arr = Array (
                      Array(-1, -1, 0, -9, -2, -2),
                      Array(-2, -1, -6, -8, -2, -5),
                      Array(-1, -1, -1, -2, -3, -4),
                      Array(-1, -9, -2, -4, -4, -5),
                      Array(-7, -3, -3, -2, -9, -9),
                      Array(-1, -3, -1, -2, -4, -5)
                  )

        val result = hourglassSum(arr)
        println(s"Result: ${result}")
    }
}