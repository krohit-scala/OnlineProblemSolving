package hackerrank.warmup

object ModifiedKaprekarNumbers {
  
  def kaprekarNumbers(p: Int, q: Int) {
    def isKaprekar(num: Int) : Boolean = {
      val squared = num.toLong * num.toLong;
      val str   = squared.toString;
      val left  = str.substring(0, str.length / 2)
      val right = str.substring(str.length / 2)
      val numL = if(left.isEmpty) 0 else left.toInt
      val numR = if(right.isEmpty) 0 else right.toInt
      
      if(numL + numR == num) {
        print(num + " ");
        return true
      } 
      else 
        return false
    }
 
    var foundKaprekar = false;
    for (num <- p to q) {
      if (isKaprekar(num)) {
          foundKaprekar = true
      }
    }
    if (!foundKaprekar) {
      println("INVALID RANGE");
    }
  }
  
  def main(args: Array[String]): Unit = {
    
  }
}