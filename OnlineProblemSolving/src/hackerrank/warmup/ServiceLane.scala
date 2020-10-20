package hackerrank.warmup

object ServiceLane {
  
  // Complete the serviceLane function below.
  def serviceLane(width: Array[Int], cases: Array[Array[Int]]): Array[Int] = {
    var result = scala.collection.mutable.ArrayBuffer[Int]()
    for(i <- 0 to cases.length-1){
      result.+=(width.slice(cases(i)(0), cases(i)(1)+1).min)
    }
    result.toArray
  }

}