package hackerrank.warmup

object CountingValleys {

    // Complete the countingValleys function below.
    def countingValleys(n: Int, s: String): Int = {
      var result = 0;
      
      // Base case check - 1 : No of steps must be equal to string of steps
      if(s == null || s.isEmpty || n != s.length)
        return -1
      
      var i, level, counter = 0
      var vallyStarted = false
      while(i < n){
        if(level == 0 && s(i).equals('D')){
          vallyStarted= true
        }

        if(s(i).equals('D'))
          level -= 1
        if(s(i).equals('U'))
          level += 1
        
        if(vallyStarted){
          if(level == 0){
            result += 1
            vallyStarted = false
          }
        }
        i += 1
      }
      result 
    }

    def main(args: Array[String]) {
        var n = 8
        var s = "UDDDUDUU"
        var result = countingValleys(n, s)
        println(result)
    }
}
