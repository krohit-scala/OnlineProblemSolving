package codility

object CompressWords {
  
  def main(args: Array[String]): Unit = {
    val word = "aba"
    val k = 2
    println(s"Final wordafter compression is: ${compressWord(word, k)}")
  }
  
  def compressWord(word: String, K: Int): String = {
    // Sanity check
    if(word.length <= K){
      return word
    }
    
    var result = ""
    var prevChar : Character = null
    var counter = 0
    var tempRes = ""
    var notedIndex = scala.collection.mutable.HashSet[Int]()
    var i = 0
    
    for(i <- 0 to word.length -1){
    	println(s"PrevChar : ${prevChar}, CurrentChar: ${word(i)}")
      if(prevChar == null){
    		prevChar = word(i)
    		counter += 1
    	}
      else if(word(i).equals(prevChar)){
    		counter += 1
    	}else{
    	  prevChar = word(i)
    	  counter = 1
    	}
    	
    	if(counter == K){
    	  println("Counter = K")
    	  notedIndex ++= (i-K+1) to i by 1 
    	  prevChar = null
    	  counter = 0
    	}
    }
    
//    while(i < word.length - 2){
//      println(s"Words: ${word(i)}, ${word(i+1)}, ${word(i+2)}")
//      if(word(i) == word(i+1) && word(i+1) == word(i+2)){
//        notedIndex.+=(i)
//        notedIndex.+=(i+1)
//        notedIndex.+=(i+2)
//        i += 3
//      }
//      else{
//        i += 1
//      }
//    }
    println(s"Noted Index: [${notedIndex.mkString(",")}]")
    if(notedIndex == null || notedIndex.isEmpty){
      println(s"Set null hai Here...")
      result = word
      println(s"no dup found in :${result}")
      return result
    }
    else{
      println(s"Set null nahi hai here...")
    	for(i <- 0 to word.length -1){
    		if(!notedIndex(i)){
    			tempRes = tempRes + word(i).toString
    		}
    	}
    	result = tempRes
    	println(s"Result: ${result}")
      compressWord(result, K)
    }
  }
}