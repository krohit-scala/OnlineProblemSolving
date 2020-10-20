package hackerrank.warmup

object SequenceEquation {
  def permutationEquation(p : Array[Int]) : Array[Int] = {
    var resultArr = new Array[Int](p.length)
    // println(s"Size: ${resultArr.length}")
    for(i <- 0 to p.length -1) {
      resultArr(p(p(p(i)-1)-1)-1) = p(i);
    }
    resultArr
  }
}