package hackerrank.warmup

object EqualizeTheArray {
  
  // Complete the equalizeArray function below.
  def equalizeArray(arr: Array[Int]): Int = {
    var maxCountKey = Int.MinValue
    var maxCount = Int.MinValue
    
    // Calculation matrix
    var map = scala.collection.mutable.HashMap[Int, Int]()
    for(elem <- arr){
      val currCount = map.getOrElse(elem, 0)
      map.put(elem, currCount+1)
      if(currCount > maxCount){
        maxCount = currCount
        maxCountKey = elem
      }
    }
    var counter = 0
    println(s"maxCountKey: ${maxCountKey}, maxCountKeyCount: ${map(maxCountKey)}")
    for(elem <- map.keys){
      println(s"Key: ${elem}, Count: ${map(elem)}")
      if(elem != maxCountKey)
        counter += map(elem)
    }
    counter
  }
  
  def main(args: Array[String]): Unit = {
    val arr1 = Array(3,3,2,1,3)
    val arr = Array(1, 2, 3, 1, 2, 3, 3, 3)
    println(s"${equalizeArray(arr)}")
  }
}