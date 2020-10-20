package hackerrank.warmup

object MigratoryBirds {
  
  def migratoryBirds(arr: Array[Int]): Int = {
    // Base case check - 1 : Null or empty array
    if(arr == null || arr.isEmpty)
      return 0
    
    // Create a hash map to store the bird count
    var birdMap = scala.collection.mutable.HashMap[Int, Int]()
    for(bird <- arr){
      birdMap.put(bird, (birdMap.getOrElse(bird, 0)+1))
    }
    // Analyse the bird count
    var count = Int.MinValue
    var birdId = Int.MaxValue
    for(currentBirdId <- birdMap.keySet){
      val tempCount = birdMap(currentBirdId)
      if(tempCount >= count){
        // Update count and bird id
        if(tempCount > count){
          birdId = currentBirdId
          count = tempCount
        }
        
        // Update only count
        if(tempCount == count && currentBirdId < birdId){
          birdId = currentBirdId
        }
      }
    }
    
    birdId
  }
    
  def main(args: Array[String]): Unit = {
    
  }
}