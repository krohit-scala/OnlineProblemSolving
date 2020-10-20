package hackerrank.warmup

object RepeatedString{

    // Complete the repeatedString function below.
    def repeatedString(s: String, n: Long): Long = {
      var result : Long = 0
      
      // Base case check - 1: If string is empty
      if(s == null || s.isEmpty)
        return 0
      
      // Base case check -2 : If string does not contain 'a'
      var aCount : Long = 0
      for(elem <- s.toCharArray){
        if(elem.equals('a'))
          aCount += 1
      }
      
      if(aCount == 0)
        return 0
      
      val noOfFullRepeatition = n/s.length
      val partialRepeatition = n%s.length
      var partialCount : Long = 0
      
      // Counting 'a' from partial string
      for(i <- 0L to partialRepeatition - 1L){
        if(s(i.toInt).equals('a'))
          partialCount += 1
      }
      result = (aCount * noOfFullRepeatition) + partialCount
      result
    }

    def main(args: Array[String]) {
        val s = "aba"
        val n : Long = 10L
        val result = repeatedString(s, n)
        println(result)
    }
}
