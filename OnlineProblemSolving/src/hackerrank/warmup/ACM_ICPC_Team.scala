package hackerrank.warmup

object ACM_ICPC_Team {
  
  // Complete the acmTeam function below.
  def acmTeam(topic: Array[String]): Array[Int] = {
    var maxCounter = 0
    var noOfTeams = 0
    
    val numTopics = topic(0).length
    // Make teams 
    for(i <- 0 to topic.length-1){
      for(j <- i+1 to topic.length-1){
        var counter = 0
        // Find out topics current team knows
        for(k <- 0 to numTopics -1){
          if((topic(i)(k) ==  '1') || (topic(j)(k) == '1'))
            counter += 1
        }
        if(counter > maxCounter){
          maxCounter = counter
          noOfTeams = 1
        }
        else if(counter == maxCounter){
          noOfTeams += 1
        }
        // println(s"Team: (${i+1}, ${j+1}), TopicCount: ${counter}")

      }
    }
    return Array(maxCounter, noOfTeams)
  }
  
  def main(args: Array[String]): Unit = {
    val topic = Array("10101", "11100", "11010", "00101")
    println(s"${acmTeam(topic).mkString(", ")}")
  }
}