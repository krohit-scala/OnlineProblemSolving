package hackerrank.warmup

object AppendAndDelete {
  
  // Complete the appendAndDelete function below.
  def appendAndDelete(s: String, t: String, k: Int): String = {
    var result = ""
    var counter = 0
    val l1 = s.length
    val l2 = t.length

    import scala.util.control.Breaks._
    breakable{
      for(i <- 0 to scala.math.min(l1, l2)-1){
        println(s"i: ${i}")
        if(s(i).equals(t(i)))
          counter += 1
        else 
          break
      }
    }
    //CASE A
    if((s.length()+t.length() - 2*counter)>k){
        result = "No"
    }
    //CASE B
    else if((s.length()+t.length() - 2*counter)%2==k%2){
        result = "Yes"
    }
    //CASE C
    else if((s.length()+t.length()-k)<0){
        result = "Yes"
    }
    //CASE D
    else{
        result = "No"
    }   
    result
  }

  // Complete the appendAndDelete function below.
  def appendAndDelete1(s: String, t: String, k: Int): String = {
    // Variable to store final result
    var result = ""
    
    // Base case check - 1: Both strings are empty
    if((s == null || s.isEmpty) && (t == null || t.isEmpty))
      result = "Yes"
    
    // Base case check - 2: s is empty but t is not
    else if((s == null || s.isEmpty) && !(t == null || t.isEmpty)){
      // By appending into s
      result = if(t.length <= k) "Yes" else "No"
    }
    // Base case check - 3: t is empty but s is not
    else if((t == null || t.isEmpty) && !(s == null || s.isEmpty)){
      // By deleting from s
      result = if(s.length <= k) "Yes" else "No"
    }
    // Tedious case
    else{
      val l1 = s.length
      val l2 = t.length
      
      // 1. Find length of matching subsequence
      var counter = 0
      
      import scala.util.control.Breaks._
      breakable{
        for(i <- 0 to scala.math.min(l1, l2)-1){
          println(s"i: ${i}")
          if(s(i).equals(t(i)))
            counter += 1
          else 
            break
        }
      }
      
      // 2. Cost of delete and append
      
      // No of elements to be deleted
      val del = l1 - counter
      // No of elements to be appended
      val append = l2 - counter
      println(s"Counter: ${counter}, Del: ${del}, Append: ${append}")
      result = if(del + append <= k) "Yes" else "No"

      // Exact no of moves check
      if((del + append < k) && l1 >= counter){
        val maxDel = del
      }
    }

    // Return the result
    result
  }
  
  def main(args: Array[String]): Unit = {
    val s = "y"
    val t = "yu"
    val k = 2
    println(s"${appendAndDelete(s, t, k)}")
  }
}