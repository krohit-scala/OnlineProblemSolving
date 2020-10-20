package hackerrank.warmup

object TimeConversion {
  /*
  * Complete the timeConversion function below.
  */
  def timeConversion(s: String): String = {
    var timeArr = s.split(":")
    if(timeArr(2).contains("PM") && timeArr(0) != "12"){
      timeArr(0) = ((timeArr(0).toInt) + 12).toString
    }
    else if(timeArr(2).contains("AM") && timeArr(0) == "12"){
      timeArr(0) = "00"
    }
    timeArr(2) = timeArr(2).substring(0, 2)
    return s"${timeArr(0)}:${timeArr(1)}:${timeArr(2)}"
  }
  
  def main(args: Array[String]): Unit = {
    val time = "12:40:45PM"
    println(s"Military time: ${timeConversion(time)}")
  }
}