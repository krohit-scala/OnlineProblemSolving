package hackerrank.warmup

object BreakingTheRecords {
  
  // Complete the breakingRecords function below.
  def breakingRecords(scores: Array[Int]): Array[Int] = {
    // Base case check - 1 : Empty or null array
    if(scores == null || scores.isEmpty)
      return null
    
    // To store intermediate results
    var minScore : Integer = null
    var maxScore : Integer = null
    var minCount, maxCount : Int = 0
    
    for(score <- scores){
      if(minScore == null){
        minScore = score
      }
        
      if(maxScore == null)
        maxScore = score
    
      if(score > maxScore){
        maxScore = score
        maxCount += 1
      }
      if(score < minScore){
        minScore = score
        minCount += 1
      }
      println(s"Min: ${minScore}, Max: ${maxScore}")
    }
    
    return Array(maxCount, minCount)
  }
  
  def main(args: Array[String]): Unit = {
    val scores = Array(10,5,20,20,4,5,2,25,1)
    println(s"Max - Min : [${breakingRecords(scores).mkString(", ")}]")
  }
}