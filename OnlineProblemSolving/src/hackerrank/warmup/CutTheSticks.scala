package hackerrank.warmup

object CutTheSticks {
  
  // Complete the cutTheSticks function below.
  def cutTheSticks(arr: Array[Int]): Array[Int] = {
    var result = scala.collection.mutable.ArrayBuffer[Int]()
    var flag = true
    var numSet = arr.toSet
    for(elem <- numSet){
      val counter = arr.count(_ >= elem)
      result.+=(counter)
    }
    result.toArray.sortWith(_>_)
  }
  
  def main(args: Array[String]): Unit = {
    val arr = Array(1,2,3,4,3,3,2,1)
    println(s"[${cutTheSticks(arr).mkString(", ")}]")
  }
}