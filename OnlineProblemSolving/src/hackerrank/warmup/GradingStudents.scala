package hackerrank.warmup

object GradingStudents {
  
  
  def gradingStudents(grades: Array[Int]): Array[Int] = {
    if(grades != null && !grades.isEmpty){
      for(i <- 0 to grades.length-1){
        if(grades(i) >= 38){
          val n = grades(i)/5
          if((n+1) * 5 - grades(i) < 3){
            grades(i) = grades(i) + (n+1) * 5 - grades(i)
          }
        }
      }
    }
    grades
  }
  
  def main(args: Array[String]): Unit = {
    val arr = Array(73,67,38,33)
    println(s"Rounded-off results: ${gradingStudents(arr).mkString(", ")}")
  }
}