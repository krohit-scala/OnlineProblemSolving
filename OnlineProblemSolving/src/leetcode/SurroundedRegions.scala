package leetcode

object SurroundedRegions {
  // Link to question: https://leetcode.com/problems/surrounded-regions/
  
  def main(args: Array[String]): Unit = {
//    var board = Array(
//                    Array('X', 'X', 'X', 'X'),
//                    Array('X', 'O', 'O', 'X'),
//                    Array('X', 'X', 'O', 'X'),
//                    Array('X', 'O', 'X', 'X')
//                )
      var board = Array(
                Array('O','O','O','O','X','X'),
                Array('O','O','O','O','O','O'),
                Array('O','X','O','X','O','O'),
                Array('O','X','O','O','X','O'),
                Array('O','X','O','X','O','O'),
                Array('O','X','O','O','O','O')
            )
//    var board = Array(
//                    Array('X','O','X','O','X','O'),
//                    Array('O','X','O','X','O','X'),
//                    Array('X','O','X','O','X','O'),
//                    Array('O','X','O','X','O','X')
//                )
//    var board = Array(
//                    Array('O','X','X','O','X'),
//                    Array('X','O','O','X','O'),
//                    Array('X','O','X','O','X'),
//                    Array('O','X','O','O','O'),
//                    Array('X','X','O','X','O')
//                )
    println(s"Input")
    board.foreach(x => println(s"${x.mkString(", ")}"))
    solve1(board)
    println(s"Output")
    board.foreach(x => println(s"${x.mkString(", ")}"))
  }

  def solve1(board: Array[Array[Char]]): Unit = {
    // Base case check - 0 : Null or empty array
    if(board ==null || board.isEmpty)
      return
    
    // Base case check - 1 : Check if board contains null or empty array
    val m = board.length
    val set = scala.collection.mutable.HashSet[Int]()
    val n = {
              board.foreach(arr => {
                if(arr == null || arr.isEmpty)
                  return
                set.+=(arr.length)
                }
              )
              set.max
            }
    
    // Base case check -2 : Check if processing is actually required
    if((m < 3) && (n < 3))
      return
    
    // Identify all the Os on the edge or connected to Os which connect to the edge
    for(i <- 0 to m-1) if(board(0)(i) == 'O') board(0)(i) = 'E'  // Top row
    for(i <- 0 to m-1) if(board(m-1)(i) == 'O') board(m-1)(i) = 'E'  // Bottom row
    for(i <- 0 to n-1) if(board(i)(0) == 'O') board(i)(0) = 'E'  // First column
    for(i <- 0 to n-1) if(board(i)(n-1) == 'O') board(i)(n-1) = 'E'  // Last column
    
    // Do the processing
    var edgeNbrFlag = false
//    for(i <- m-2 to 1 by -1){
//      for(j <- n-2 to 1 by -1){
//        // Check if any neighbor is at the edge and 'O'
//        edgeNbrFlag = (
//                          board(i)(j-1) == 'E'
//                          || board(i)(j+1) == 'E' 
//                          || board(i-1)(j) == 'E'
//                          || board(i+1)(j) == 'E'
//                    )
//        println(s"i: ${i}, j: ${j}, Edge condition: ${edgeNbrFlag}")
//        if(board(i)(j) == 'O' && edgeNbrFlag)
//          board(i)(j) = 'E'
//      }
//    }
    var row = m-2
    var col = n-2
    var i, j = 0
    while(row > 0 && col > 0){
        // Go up the row
        for(i <- row-1 to 0 by -1){
          edgeNbrFlag = (
                      board(row)(col-1) == 'E'
                      || board(row)(col+1) == 'E' 
                      || board(row-1)(col) == 'E'
                      || board(row+1)(col) == 'E'
                )
          if(board(i)(col) == 'O' && edgeNbrFlag){
            board(i)(col) = 'E'
          }
        }
        
        // Go left to the col
        for(j <- col-1 to 0 by -1){
          edgeNbrFlag = (
                      board(row)(col-1) == 'E'
                      || board(row)(col+1) == 'E' 
                      || board(row-1)(col) == 'E'
                      || board(row+1)(col) == 'E'
                )
          if(board(row)(j) == 'O' && edgeNbrFlag){
            board(row)(j) = 'E'
          }
        }
        row -= 1
        col -= 1
    }
    // Intermediate results
    println(s"After identifying edges")
    board.foreach(x => println(s"${x.mkString(", ")}"))

    // Convert 'E' back to 'O'
    for(i <- 0 to m-1){
      for(j <- 0 to n-1){
        if(board(i)(j) == 'E')
          board(i)(j) = 'O'
        else if(board(i)(j) == 'O')
          board(i)(j) = 'X'
      }
    }
  }

  def solve(board: Array[Array[Char]]): Unit = {
    // Base case check - 0 : Null or empty array
    if(board ==null || board.isEmpty)
      return
    
    // Base case check - 1 : Check if board contains null or empty array
    val m = board.length
    val set = scala.collection.mutable.HashSet[Int]()
    val n = {
              board.foreach(arr => {
                if(arr == null || arr.isEmpty)
                  return
                set.+=(arr.length)
                }
              )
              set.max
            }
    
    // Base case check -2 : Check if processing is actually required
    if((m < 3) && (n < 3))
      return
    
    // Do the processing
    var edgeNbrFlag = false
    for(i <- 1 to m-2){
      for(j <- 1 to n-2){
        // Check if any neighbor is at the edge and 'O'
        edgeNbrFlag = (
                          (board(i)(j-1) == 'O' && j-1 == 0) 
                          || (board(i)(j+1) == 'O' && j+1 == m-1)
                          || (board(i-1)(j) == 'O' && i-1 == 0) 
                          || (board(i+1)(j) == 'O' && i+1 == n-1)
                    )
        println(s"Edge condition: ${edgeNbrFlag}")
        if(board(i)(j) == 'O' && edgeNbrFlag == false)
          board(i)(j) = 'X'
      }
    }
  }
}