package hackerrank.warmup


object LibraryFine {

  // Complete the libraryFine function below.
  def libraryFine(d1: Int, m1: Int, y1: Int, d2: Int, m2: Int, y2: Int): Int = {
    // Calculations required
    import java.time.LocalDate
    import java.time.temporal._
    
    // Formatting the dates
    // Return date
    val dt1 = s"${y1}-${if(m1 < 10) s"0${m1}" else m1}-${{if(d1 < 10) s"0${d1}" else d1}}"
    // Expected date of return
    val dt2 = s"${y2}-${if(m2 < 10) s"0${m2}" else m2}-${{if(d2 < 10) s"0${d2}" else d2}}"

    // Parsing the dates
    val s1 = LocalDate.parse(dt1)
    val s2 = LocalDate.parse(dt2)
    
    var smallerDate, biggerDate : LocalDate = null

    println(s"s1 - s2: ${ChronoUnit.DAYS.between(s1, s2)}")
    println(s"s2 - s1: ${ChronoUnit.DAYS.between(s2, s1)}")
    
    // Finding the bigger date
    if(ChronoUnit.DAYS.between(s2, s1) <= 0){
      return 0
    }
    else{
      var fine = 0
      
      smallerDate = s2
      biggerDate = s1
      
      // Not on time return
      // Finiding days, months, year difference
      val numYears = ChronoUnit.YEARS.between(smallerDate, biggerDate)
      val numMonths = ChronoUnit.MONTHS.between(smallerDate, biggerDate)
      val numDays = ChronoUnit.DAYS.between(smallerDate, biggerDate)
      
      println(s"Days: ${numDays}, Months: ${numMonths}, Years: ${numYears}")

      // If within the same month
      if(numDays > 0 && numMonths == 0.0 && y1 == y2)
        fine = numDays.toInt * 15
      else if(numMonths > 0.0 && numYears == 0.0 && y2 == y1)
        fine = (m1-m2).toInt * 500
      else if(numMonths > 0.0 && (numYears > 0.0 || y2 > y1))
        fine = 10000
      else 
        fine = 10000
      return fine
    }
   
  }

  def main(args: Array[String]): Unit = {
    println(libraryFine(1, 1, 2015, 31, 12, 2014))
  }
}