package hackerrank.warmup

object DayOfTheProgrammer {
  
  // Complete the dayOfProgrammer function below.
  def dayOfProgrammer(year: Int): String = {
    if(year == 1918)
      return "26.09.1918"
    else if(
          ((year <= 1917) && (year%4 == 0)) || ( ( (year > 1918) && (year%400 == 0) ) || ( (year%4 == 0) & (year%100 != 0) ) )
        )
      return "12.09." +year
    else
      "13.09." +year
  }
  
  def main(args: Array[String]): Unit = {
    
  }
}