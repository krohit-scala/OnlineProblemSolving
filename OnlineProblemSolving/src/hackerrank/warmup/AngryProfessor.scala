package hackerrank.warmup

object AngryProfessor {
  
  // Complete the angryProfessor function below.
  def angryProfessor(k: Int, a: Array[Int]): String = {
    val count = a.count(p => p <= 0)
    return if(count >= k) "NO" else "YES"
  }
  
  def main(args: Array[String]): Unit = {
    
  }
}