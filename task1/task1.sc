import scala.annotation.tailrec
import scala.language.postfixOps

val week = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

// 1A
println("for loop")

def weekForLoop(week: List[String]) = {
  var forWeek = ""
  for (day <- week) {
    forWeek += s"$day, "
  }
  forWeek.dropRight(2)
}

println(weekForLoop(week))

// 1B
println("for loop starts with p")

def weekForLoopStartP(week: List[String]) = {
  var forWeek = ""
  for (day <- week if day.startsWith("P")) {
    forWeek += s"$day, "
  }

  forWeek.dropRight(2)
}

println(weekForLoopStartP(week))

// 1C
println("while loop")

def weekWhileLoop(week: List[String]) = {
  var forWeek = ""
  var i = 0
  while (i < week.length) {
    forWeek += s"${week(i)}, "
    i += 1
  }
  forWeek.dropRight(2)
}

println(weekWhileLoop(week))

// 2A
println("rekurencja")

def weekRecFun(week: List[String]): String = {

  if (week.isEmpty)
    return ""

  val tail = weekRecFun(week.tail)
  val suffix = if (tail.isBlank) "" else s", $tail"
  s"${week.head}$suffix"
}

println(weekRecFun(week))

// 2B
println("rekurencja odwrócona")

def weekRecFunReversed(week: List[String]): String = {
  if (week.isEmpty)
    return ""

  val tail = weekRecFunReversed(week.tail)
  val prefix = if (tail.isBlank) "" else s"$tail, "
  s"$prefix${week.head}"
}

println(weekRecFunReversed(week))

// 3
println("rekurencja ogonowa")

def weekTailRec(week: List[String]): String = {
  @tailrec
  def weekTail(weekPart: List[String], result: String): String = {
    val newResult = s"$result, ${weekPart.head}"
    if (weekPart.tail.isEmpty) newResult
    else weekTail(weekPart.tail, newResult)
  }
  if (week.isEmpty) ""
  else weekTail(week.tail, week.head)
}

println(weekTailRec(week))

// 4A
println("foldl")

def weekFoldLeft(week: List[String]): String = {
  week.foldLeft("")(_ + ", " + _).drop(2)
}

println(weekFoldLeft(week))

// 4B
println("foldr")

def weekFoldRight(week: List[String]): String = {
  week.foldRight("")(_ + ", " + _).dropRight(2)
}

println(weekFoldRight(week))

// 4C
println("foldl starts with p")

def weekFoldLeftStartP(week: List[String]): String = {
  week.filter(_ startsWith "P")
    .foldLeft("") { (result, item) => s"$result, $item" }
    .drop(2)
}

println(weekFoldLeftStartP(week))

// 5
println("maps")

val prices = Map("rock" -> 3f, "paper" -> 2f, "scissors" -> 1f)
println(prices)

val reduced = prices.view.mapValues(price => price * 0.7f).toMap
println(reduced)

// 6
println("tuples")

def funTuple(tuple: (String, Float, Int)): String = {
  val (name, price, quantity) = tuple
  s"$name $price $quantity"
}

println(funTuple("rock", 4f, 77))

// 7
println("options")

val mapOptions = Map(1 -> 5f)
println(mapOptions.get(1))
println(mapOptions.get(2))
println(mapOptions.getOrElse(2, 30f))

// 8
println("zeroes")

def deleteZeros(list: List[Int]): List[Int] = {
  if (list.isEmpty)
    return List.empty

  if (list.head != 0) {
    list.head :: deleteZeros(list.tail)
  } else {
    deleteZeros(list.tail)
  }
}

val inputNumbers = List(-2, -1, 0, 1, 2, 7, 69, 88, 99)
println(deleteZeros(inputNumbers))

// 9
println("increment")

def mapIncrement(list: List[Int]): List[Int] = {
  list.map(_ + 1)
}

println(mapIncrement(inputNumbers))

// 10
println("absolute <-5, 12>")

def returnAbsolute(list: List[Double]): List[Double] = {
  list.filter(_ >= -5d)
    .filter(_ <= 12d)
    .map(_ abs)
}

val inputDoubleNumbers = List(1d, 2d, 3d, 0d, 5d, -6d, 100d, -10.0d)
println(returnAbsolute(inputDoubleNumbers))