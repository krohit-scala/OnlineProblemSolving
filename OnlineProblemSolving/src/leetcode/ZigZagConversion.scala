package leetcode

object ZigZagConversion {
  // Link to question: https://leetcode.com/problems/zigzag-conversion/
  def main(args: Array[String]): Unit = {
    println(s"${convert("PAYPALISHIRING", 4)}")
  }
  
  def convert(str: String, numRows: Integer) : String = {
    if(numRows == 1 || str.length <= numRows )
      str
    else{
      var zigzag = new Array[String](numRows)
      var row = 0
      var step = 0
      
      for(i <- 0 to str.length - 1){
        if(zigzag(row) == null || zigzag(row).isEmpty())
          zigzag(row) = str(i).toString
        else
          zigzag(row) = zigzag(row) + str(i).toString
        
        if(row == 0)
          step = 1
        if(row == numRows -1)
          step = -1
        
        row += step
      }
      
      zigzag.mkString
    }
  }
  
}