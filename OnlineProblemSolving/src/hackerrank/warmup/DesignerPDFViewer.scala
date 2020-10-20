package hackerrank.warmup

object DesignerPDFViewer {
  
  // Complete the designerPdfViewer function below.
  def designerPdfViewer(h: Array[Int], word: String): Int = {
    var maxHeight = 0
    for(alphabet <- word){
      val index = alphabet.toInt - 96 -1
      if(h(index) > maxHeight)
        maxHeight = h(index)
    }
    
    return maxHeight * word.length
  }
  
  def main(args: Array[String]): Unit = {
    val word = "abc"
    val h = Array(1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,7)
    println(s"${designerPdfViewer(h, word)}")
  }
}