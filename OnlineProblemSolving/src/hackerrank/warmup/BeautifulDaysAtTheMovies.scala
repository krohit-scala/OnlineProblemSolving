package hackerrank.warmup

object BeautifulDaysAtTheMovies {
  // Complete the beautifulDays function below.
  def beautifulDays(i: Int, j: Int, k: Int): Int = {
    var count = 0
    
    for(num <- i to j){
      val numReverse = num.toString.reverse.toInt
      if(scala.math.abs(num - numReverse) % k == 0)
        count += 1
    }
    count
  }
  
  def main(args: Array[String]): Unit = {
    val i = 20
    val j = 23
    val k = 6
    println(s"${beautifulDays(i, j, k)}")
  }
}