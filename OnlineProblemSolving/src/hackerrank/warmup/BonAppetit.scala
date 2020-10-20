package hackerrank.warmup

object BonAppetit {
  
  // Complete the bonAppetit function below.
  def bonAppetit(bill: Array[Int], k: Int, b: Int) {
    if((bill == null || bill.isEmpty) || k > bill.length-1)
      println("Bon Appetit")
  
    var total = 0
    for(i <- 0 to bill.length -1){
      if(i != k)
        total += bill(i)
    }
    println(s"Total: ${total}")
    if(total/2 == b)
      println("Bon Appetit")
    else if(b > total/2)
      println(s"${b - total/2}")

  }
  
  def main(args: Array[String]): Unit = {
    val bill = Array(3,10,2,9)
    val k = 1
    val b = 7
    bonAppetit(bill, k, b)
  }
}