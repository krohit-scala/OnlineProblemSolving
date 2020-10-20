package hackerrank.warmup

object DrawingBook {
    /*
    * Complete the pageCount function below.
    */
  def pageCount(n: Int, p: Int): Int = {
    /*
      * Write your code here.
    */
    // Base case check - 1 : If page is at the start or end
    if(p == 1 || p == n)
      return 0
    
    // base case check - 2 : No of pages is even and p = n-1
    if(n%2==0 && p == n-1)
      return 1
    
    // If n is odd 
    val end = if(n%2 == 0) n-1 else n
    val mid = if(n%2 == 0) n/2 else (n/2 + 1)
    var count = 0
    // Start from the start
    import scala.util.control.Breaks._
    breakable{
      if(p <= mid){
        for(i <- 2 to mid by 2){
          val j = i+1
          count += 1
          if(p == i || p == j)
            break
          println(s"i: ${i}, j: ${j}")
        }
      }
      // Start from the end
      else{
        for(i <- (n to mid+1 by -2)){
          val j = if(i == n) i else i-1
          if(p == i || p == j)
            break
          count += 1
          println(s"i: ${i},j: ${j}")
        }
      }
    }
    return count
  }
  
  def main(args: Array[String]): Unit = {
    val n = 6
    val p = 5
    println(s"Page count: ${pageCount(n, p)}")
  }
}