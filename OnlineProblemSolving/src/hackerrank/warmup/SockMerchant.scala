package hackerrank.warmup

object SockMerchant {
    def main(args: Array[String]) {
        val n = 9
        val ar = Array(10,20,20,10,10,30,50,10,20)
        val result = sockMerchant(n, ar)
        println(result)
    }
    
    // Complete the sockMerchant function below.
    def sockMerchant(n: Int, ar: Array[Int]): Int = {
      // Base case check : n != ar.length
      if(n != ar.length)
        return 0
        
      var result = 0
      var sockMap : scala.collection.mutable.HashMap[Int, Int] = scala.collection.mutable.HashMap[Int, Int]()
      for(elem <- ar)
        sockMap.put(elem, (sockMap.getOrElse(elem, 0) + 1))
      
      for(elem <- sockMap.keys){
        println(s"Key: ${elem}, Value: ${sockMap(elem)}")
        result = result + (sockMap(elem)/2)
      }
      result
    }
}
