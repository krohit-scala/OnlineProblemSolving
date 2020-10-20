package hackerrank.warmup

object UtopianTree {
  
  // Complete the utopianTree function below.
  def utopianTree(n: Int): Int = {
    if(n == 0)
      return 1
      
    var result = 1
    for(i <- 1 to n){
      if(i%2 != 0){
        // Next spring cycle
        result *= 2
      }
      else{
        // Summer
        result += 1
      }
      println(s"i: ${i}, Temp height: ${result}")
    }
    result
  }
  
  def main(args: Array[String]): Unit = {
//    val arr = Array(0,1,4)
    val arr = Array(4)
    arr.foreach(f => println(s"n: ${f}, ${utopianTree(f)}"))
  }
}