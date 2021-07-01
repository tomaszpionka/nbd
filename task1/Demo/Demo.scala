package Demo

import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Demo {
  def main(args: Array[String]): Unit = {
    // 1. weekday list
    val weekDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

    // a) for loop
    println()
    println("task 1 a)")
    task1a(weekDays)

    // b) for loop starts with "P"
    println()
    println("task 1 b)")
    println(task1b(weekDays))

    // c) while loop
    println()
    println("task 1 c)")
    println(task1c(weekDays))

    // 2.
    // a) rec. function
    println()
    println("task 2 a)")
    println(task2a(weekDays))
    // b) rec. function reversed
    println()
    println("task 2 b)")
    println(task2b(weekDays))

    // 3. tail function
    println()
    println("task 3")
    println(task3(weekDays))

    // 4.
    // a) foldl
    println()
    println("task 4 a)")
    println(task4a(weekDays))

    // b) foldr
    println()
    println("task 4 b)")
    println(task4b(weekDays))

    // c) foldl starts with „P”
    println()
    println("task 4 c)")
    println(task4c(weekDays))

    // 5) maps
    println()
    println("task 5")
    val products = Map("Chleb" -> 4, "Owoce" -> 3, "Warzywa" -> 2)
    val productsSale = products map { case (key, value) => (key, value * 0.9) }
    println(productsSale)

    // 6) tuple
    println()
    println("task 6")
    task6("text", 1, weekDays)

    // 7) options
    println()
    println("task 7")
    val pricePerBread = products.get("Chleb")
    // Some
    println(pricePerBread)
    val pricePerMilk = products.get("Mleko")
    // None
    println(pricePerMilk)

    // 8) rec. zeroes
    println()
    println("task 8")
    val intList = List(2, 2, 1, -6, 1, 2, 6, 0, -6, 0, 8)
    println(task8(intList))

    // 9) increment
    println()
    println("task 9")
    println(task9(intList))

    // 10) interval
    println()
    println("task 10")
    val biggerIntList = List(-69, -56, -34, -10, -5, -1, 0, 1, 2, 6, 13, 16, 23, 43, 56, 78)
    println(task10(biggerIntList))
  }

  def task1a(weekDays: List[String]) = {
    var combinedString = "";
    for (i <- 0 until weekDays.length) {
      if (combinedString != "")
        combinedString += ", " + weekDays.get(i)
      else
        combinedString += weekDays.get(i)
    }
    println(combinedString)

  }

  def task1b(weekDays: List[String]) = {
    var combinedString = "";
    for (i <- 0 until weekDays.length) {
      breakable {
        if (!weekDays.get(i).startsWith("P")) break
        if (combinedString != "")
          combinedString += ", " + weekDays.get(i)
        else
          combinedString += weekDays.get(i)
      }


    }
    combinedString;
  }

  def task1c(weekDays: List[String]) = {
    var combinedString = ""
    var index = 0;
    while (index < weekDays.length) {
      if (combinedString != "")
        combinedString += ", " + weekDays.get(index)
      else
        combinedString += weekDays.get(index)

      index = index + 1;
    }

    combinedString
  }

  def task2a(weekDays: List[String]) = {
    def addAnotherDay(i: Int): String = {
      if (i == weekDays.length) return ""

      val currentDay = if (i == weekDays.length - 1) weekDays.get(i) else weekDays.get(i) + ", "

      currentDay + addAnotherDay(i + 1)
    }

    addAnotherDay(0);
  }

  def task2b(weekDays: List[String]): String = {
    def addAnotherDay(i: Int): String = {
      if (i == -1) return ""

      val currentDay = if (i == 0) weekDays.get(i) else weekDays.get(i) + ", "

      currentDay + addAnotherDay(i - 1)
    }

    addAnotherDay(weekDays.length - 1)
  }

  def task3(weekDays: List[String]) = {
    @tailrec
    def addAnotherDay(i: Int, combinedString: String): String = {
      if (i == weekDays.length) return combinedString

      val currentDay = if (i == weekDays.length - 1) weekDays.get(i) else weekDays.get(i) + ", "

      addAnotherDay(i + 1, combinedString + currentDay)
    }

    addAnotherDay(0, "")
  }

  def task4a(weekDays: List[String]): String = {
    weekDays.fold("") { (sum, curr) => {
      sum + curr + ", "
    }
    }.dropRight(2)
  }

  def task4b(weekDays: List[String]): String = {
    weekDays.foldRight("") { (sum, curr) => {
      sum + ", " + curr
    }
    }.dropRight(2)
  }

  def task4c(weekDays: List[String]): String = {
    weekDays.fold("") { (sum, curr) => {
      if (curr.startsWith("P"))
        sum + curr + ", "
      else sum

    }
    }.dropRight(2)
  }

  def task6(tup: (String, Int, Any)) = {
    println(tup._1)
    println(tup._2)
    println(tup._3)
  }

  def task8(intList: List[Int]): List[Int] = {
    def iter(index: Int, currentList: List[Int]): List[Int] = {
      if (index >= currentList.length) return currentList;

      val (part1, part2) = currentList.splitAt(index)

      if (currentList.get(index) == 0)
        iter(index + 1, part1 ++ part2.tail)
      else
        iter(index + 1, currentList)
    }
    
    iter(0, intList)
  }

  def task9(intList: List[Int]): List[Int] = {
    intList map (el => el + 1)
  }

  def task10(intList: List[Int]): List[Int] = {
    val filteredList = intList filter (el => el >= -5 && el <= 12)

    filteredList map (el => el.abs)
  }
}
