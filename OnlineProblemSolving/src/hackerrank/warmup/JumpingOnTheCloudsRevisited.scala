package hackerrank.warmup

object JumpingOnTheCloudsRevisited {
  
  // Complete the jumpingOnClouds function below.
  def jumpingOnClouds(c: Array[Int], k: Int): Int = {
    // Flag to know if the game is over
    var flag = false
    var i = 0
    val n = c.length
    var cost = -1
    var count = 0
    while(!flag){
      //Check if the game ended
      if((i)%n == 0 && count != 0){
        flag = true
        cost += 1
      }
      else{
        if(c((i + k)%n) == 1)
          cost += 3
        else
          cost += 1
        i = (i + k)%n
      }
      count += 1
    }
    return 100 - cost
  }
  
  
  def main(args: Array[String]): Unit = {
    
  }
}