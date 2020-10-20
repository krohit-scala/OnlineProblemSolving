package hackerrank.warmup

object CavityMap {
  // Complete the cavityMap function below.
  def cavityMap(grid: Array[String]): Array[String] = {
    var tempArr = new Array[Array[String]](grid.length)
    var indices = new scala.collection.mutable.ArrayBuffer[(Int, Int)]
    var result = scala.collection.mutable.ArrayBuffer[String]()
    
    // Parsed the grid as 2-D array
    for(i <- 0 to grid.length-1){
      tempArr(i) = grid(i).toCharArray.map(_.toString)
      println(s"${tempArr(i).mkString(", ")}")
    }
    
    for(i <- 1 to tempArr(0).length -2){
      for(j <- 1 to tempArr.length-2){
        val currElem = tempArr(i)(j).toInt
        val upElem = tempArr(i)(j-1).toInt
        val downElem = tempArr(i)(j+1).toInt
        val leftElem = tempArr(i-1)(j).toInt
        val rightElem = tempArr(i+1)(j).toInt
        if(currElem > upElem && currElem > downElem && currElem > leftElem && currElem > rightElem){
          println(s"cavity found at i:${i}, j:${j}, ${tempArr(i)(j)}")
          indices.+=((i, j))
        }
      }
    }

    for((i, j) <- indices){
      println(s"${i}, ${j}")
      tempArr(i)(j) = "X"
      println(s"${tempArr(i)(j)}")
    }

    // Zip the 2D array back to 1D array
    for(i <- 0 to tempArr.length-1){
      result.+=(tempArr(i).mkString(""))
    }
    result.toArray
  }
  
  // Complete the cavityMap function below.
  def cavityMap1(grid: Array[String]): Array[String] = {
    var indices = new scala.collection.mutable.ArrayBuffer[(Int, Int)]
    
    for(i <- 1 to grid(0).length -2){
      for(j <- 1 to grid.length-2){
        val currElem = grid(i).charAt(j).toInt
        val upElem = grid(i).charAt(j-1).toInt
        val downElem = grid(i).charAt(j+1).toInt
        val leftElem = grid(i-1).charAt(j).toInt
        val rightElem = grid(i+1).charAt(j).toInt
        if(currElem > upElem && currElem > downElem && currElem > leftElem && currElem > rightElem){
          indices.+=((i, j))
        }
      }
    }

    for((i, j) <- indices)
      grid(i) = grid(i).substring(0, j) + "X" + grid(i).substring(j+1)

    grid
  }
  
  
  def main(args: Array[String]): Unit = {
    var arr1 = Array(
                "1112",
                "1912",
                "1892",
                "1234"
               )
    
    val arr2 = Array(
                "989",
                "191",
                "111"
               )
				
		val brr1 = cavityMap1(arr1)
		val brr2 = cavityMap1(arr2)
		println(s"${brr1.mkString("\n")} \n\n ${brr2.mkString("\n")}")
  }
}