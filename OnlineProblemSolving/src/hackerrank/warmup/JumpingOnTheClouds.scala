package hackerrank.warmup

object JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    def jumpingOnClouds(c: Array[Int]): Int = {
      var i, count = 0
      val n = c.length
      
      // Base case check : Can not step foot
      if(c(0) == 1)
        return -1
      
      while(i < c.length -1){
        // Jump -2
        if((i+2 <= n-1) && c(i+2) != 1){
          println(s"Jumping 2...")
          i += 2
        }
        // Jump -2 
        else if((i+1 <= n-1) && c(i+1) != 1){
          println(s"Jumping 1...")
          i += 1
        }
        count += 1
      }
      count
    }

    def main(args: Array[String]) {
        var n = 7
        var c = "0 0 1 0 0 1 0".split(" ").map(_.trim.toInt)
        var result = jumpingOnClouds(c)
        println(result)
        
        n = 6
        c = "0 0 0 0 1 0".split(" ").map(_.trim.toInt)
        result = jumpingOnClouds(c)
        println(result)
        
    }
}
