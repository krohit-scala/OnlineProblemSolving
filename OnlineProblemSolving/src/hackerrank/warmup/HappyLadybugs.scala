package hackerrank.warmup

object HappyLadybugs {
  // Complete the happyLadybugs function below.
  def happyLadybugs(b: String): String = {
    var map = scala.collection.mutable.HashMap[Char, Int]()
    
    for(char <- b.toCharArray){
      map.put(char, map.getOrElse(char, 0)+1)
    }
    //map.keys.foreach(k => println(s"k: ${k}, v: ${map(k)}"))
    
    var dashCounter = map.getOrElseUpdate('_', 0)
    
    var result = "YES"
    for(char <- map.keys){
      // Check for a lonely ladybug
      if(map(char) == 1 && char != '_')
        result = "NO"
      
      // Check if all are same
      if(map(char) == b.length && dashCounter == 0)
        result = "YES"
      
      // Check if all are same with spaces
      if(map(char) + dashCounter == b.length && dashCounter != 0)
        result = "YES"
        
      //if(map(char) + dashCounter == b.length map.keys.count(_.isInstanceOf[Char]) )
    }
//    if(result == "YES" && dashCounter == 0)
//      result = "NO"
    
    
    result
  } 
  
  def main(args: Array[String]): Unit = {
    val arr = Array("_", "RBRB", "RRRR", "BBB", "BBB_")
    for(str <- arr)
      println(s"${happyLadybugs(str)}")
//    println(s"${happyLadybugs("RBX_YBR")}")
  }
}