package Demo

object Main {

  def main(args: Array[String]): Unit = {
    //1
    println()
    println("task 1")
    println(task1("Wtorek"))
    println(task1("Niedziela"))
    println(task1("Wtoniedziałek"))

    //2
    println()
    println("task 2")
    val konto1 = new KontoBankowe(420)
    println(konto1.stanKonta)

    val konto2 = new KontoBankowe()
    println(konto2.stanKonta)
    println(konto2.wplata(1000))
    println(konto2.wyplata(500))
    println(konto2.wyplata(500))
    println(konto2.wyplata(500))

    //3
    println()
    println("task 3")

    val osoba1 = Osoba("Mariusz", "Pudzianowski")
    val osoba2 = Osoba("Adam", "Małysz")
    val osoba3 = Osoba("Robert", "Kubica")
    val osoba4 = Osoba("Dominik", "Dominik")

    task3(osoba1)
    task3(osoba2)
    task3(osoba3)
    task3(osoba4)

    //4
    println()
    println("task 4")

    val number = 7

    def timesSeven(num: Int): Int = num * 7

    println(task4(number, timesSeven))

    //5
    println()
    println("task 5")

    val osoba5 = new Osoba("Adam", "Kowalski") with Student
    println(s"Students tax: ${osoba5.podatek}%")

    val osoba6 = new Osoba("Bartek", "Kowalski") with Pracownik
    println(s"Workers tax: ${osoba6.podatek}%")

    val osoba7 = new Osoba("Czarek", "Kowalski") with Nauczyciel
    println(s"Teachers tax: ${osoba7.podatek}%")

    val osoba8 = new Osoba("Damian", "Kowalski") with Student with Pracownik
    println(s"Students who is working tax: ${osoba8.podatek}%")

    val osoba9 = new Osoba("Emil", "Kowalski") with Pracownik with Student
    println(s"Worker who is studying tax: ${osoba9.podatek}%")
  }

  def task1(str: String): String = {
    val workingDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek")
    val weekendDays = List("Sobota", "Niedziela")

    str match {
      case a if (workingDays.contains(a)) => "Praca"
      case b if (weekendDays.contains(b)) => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }

  def task3(osoba: Osoba) = {
    val greeting = osoba match {
      case Osoba("Mariusz", "Pudzianowski") => "Polska górą!"
      case Osoba("Marcin", "Najman") => "Tu nikogo nie ma!"
      case Osoba("Adam", "Małysz") => "Cześć i czołem!"
      case _ => "Hello there."
    }

    println(greeting)
    greeting
  }

  def task4(number: Int, fun: (Int) => Int): Int = {
    fun(fun(fun(number)))
  }
}
