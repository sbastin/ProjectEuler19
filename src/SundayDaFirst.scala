/**
 * Created by sbastin on 8/11/15.
 */
object SundayDaFirst {

  val days = Map(
    0 -> "Sunday",
    1 -> "Monday",
    2 -> "Tuesday",
    3 -> "Wednesday",
    4 -> "Thursday",
    5 -> "Friday",
    6 -> "Saturday")

  var sundayTotal = 0

  //For the initial 1st's of the month, represent each month's 1st by a list entry
  var firstsOfTheMonth = List(2,5,5,1,3,6,1,4,0,2,5,0)
  val years = 1901 to 2000

   def main (args: Array[String]) {
println (years)
     years.foreach(x => {
       isLeapYear(x) match {
         case true => findSundays(firstsOfTheMonth, 2)
         case _ => findSundays(firstsOfTheMonth, 1)
       }
     })

  }

  private def advanceToNextFirsts(firstsOfTheMonths: List[Int], shiftValue: Int) = {
    firstsOfTheMonths.map(x => (x + shiftValue) % 7)
  }

  private def findSundays(firsts: List[Int], shiftValue: Int) {
    sundayTotal += firsts.count(_ == 0)
    println(":: " + sundayTotal + " ::")
    firstsOfTheMonth = advanceToNextFirsts(firsts, shiftValue)
  }

  private def isLeapYear(year:Int): Boolean = {
    println("Year: " + year)
    if(year % 4 == 0 && year % 400 != 0) {
      println("   -" + "true")
      true

    }
    else{
      println("   -" + "false")
      false
    }
  }
}
