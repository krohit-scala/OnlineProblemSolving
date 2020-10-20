package leetcode

object DecodingWays {
	// Link to question: https://leetcode.com/problems/decode-ways/
  def main(args: Array[String]): Unit = {
    println(s"Number of ways: ${numDecodings("0")}")
  }
  
  def decode(str : String, k : Int, memo : Array[Integer]) : Int = {
     if(k == 0)
      return 1

    var start = str.length - k
     println(s"String number: ${str}, k: ${k}, start: ${start}")
    
    if(str(start) == '0'){
      println(s"I'm here: ${str(start)}")
      return 0
    }
    
    if(memo(k) != null)
      return memo(k)
    
    var result = decode(str, k-1, memo)
    if(k >=2 && (str.substring(start, start+2)) <= "26"){
      result += decode(str, k-2, memo)
    }
   memo(k) = result
   return result
 
  }
  
  def numDecodings(s: String): Int = {
    val len = s.length + 1
    var memo : Array[Integer] = Array.fill(len){null}
    // println(s"Memo array created: ${memo.mkString(", ")}")
    decode(s, s.length, memo)
	}
  
  
  
  def numDecodings1(str: String) : Int = {
	  var digit = str.toArray[Char]
	  
	  var prevOfPrev = 1
    var prev = 1
    var curr = 0;
	  
	  for (i <- 0 to digit.length-1) {
		  //Number of ways upto previous elements (by adding current element(ex: 6) to the encoded strings (2,1) (21) => (2,1,6) (21, 6) which is prev ways
		  curr = if(digit(i) == '0') 0 else prev
		  
		  //If previous & current element makes a number b/w 1 to 26 then this number can be just added to encoded strings upto i-2 which is prevOfPrev ways
		  if (i > 0 && (digit(i-1) == '1' || digit(i-1) == '2' && digit(i) < '7'))
		    curr += prevOfPrev
		  prevOfPrev = prev
		  prev = curr
	  }
	  if(str == null) 0 else curr
  }
}