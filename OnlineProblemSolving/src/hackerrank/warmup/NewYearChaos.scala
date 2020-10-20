package hackerrank.warmup

object NewYearChaos {
  
  // Complete the minimumBribes function below.
  def minimumBribes(q: Array[Int]) {
    // Base case check - 1: Null/empty array
    if(q == null && q.isEmpty)
      return
    
    var bribe = 0
    var flag = false
    import scala.util.control.Breaks._
    breakable{
      for(i <- 0 to q.length-1){
        println(s"current: ${q(i)}, previous: ${q(i-1)}")
        if(q(i) > i+1){
          if(q(i) == i+1 +2){
            bribe += 2
          }
          else if(q(i) == i+1 +1){
            bribe += 1
          }
          else{
            println(s"Too chaotic")
            flag = true
            break
          }
        }
      } // for loop ends here
    } // breakable ends here
    if(!flag)
      println(s"${bribe}")
  }

  def main(args: Array[String]) {
    val arr = Array(1,2,5,3,7,8,6,4)
    val brr = Array(1,2,5,3,7,8,6,4).sum
    minimumBribes(arr)
  }
}
