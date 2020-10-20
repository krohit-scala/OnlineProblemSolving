package hackerrank.warmup

object ViralAdvertising {
  // Complete the viralAdvertising function below.
  def viralAdvertising(n: Int): Int = {
    var result = 0
    var newFolks = 5

    for(i <- 1 to n){
      val peopleLiked = scala.math.floor(newFolks/2).toInt
      result += peopleLiked
      newFolks = peopleLiked * 3
    }
    result
  }
  
  def main(args: Array[String]): Unit = {
    val n = 3
    println(viralAdvertising(n))
  }
}