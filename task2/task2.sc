import org.s23702.task2.{KontoBankowe, Osoba}

// 1
def dayPatternMatching(day: String) = {
  day.toUpperCase match {
    case "Poniedziałek" | "Wtorek" | "Środa" | "Ccwartek" | "Piątek" => "Praca"
    case "Sobota" | "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }
}

val week = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
  for (day <- week) {
    println(dayPatternMatching(day))
  }

println(dayPatternMatching("niedziałek"))


// 2
val emptyBankAccount = new KontoBankowe();
println(emptyBankAccount.stanKonta)

val myBankAccount = new KontoBankowe(100);
println(myBankAccount.stanKonta)
myBankAccount.deposit(500)
println(myBankAccount.stanKonta)
myBankAccount.withdrawal(350)
println(myBankAccount.stanKonta)
myBankAccount.withdrawal(350)
println(myBankAccount.stanKonta)

// 3
def greetPerson(osoba: Osoba): String = osoba match {
  case Osoba("Kasia", Kowal") => "Hej, Kasiu!"
  case Osoba("Steve", "Black") => "Hi, Steve!"
  case _ => "Hello there!"
}

val kasia = Osoba("Ania", "Zegar")
val steve = Osoba("John", "Smith")
val rupert = Osoba("Rupert", "Sparks")

println(greetPerson(kasia))
println(greetPerson(steve))
println(greetPerson(rupert))


// 4
def tripleFunction(value: Int, action: (Int) => Int): Int = {
    action(action(action(value)))
}

println(tripleFunction(2, x => 2 * x))

// 5

trait Student extends Osoba_2 { override def tax = 0 }
trait Worker extends Osoba_2 {
    var _salary: Integer = 0
    def salary() {
      _salary
    }
    def salary_=(new_salary: Integer): Unit = {
      _salary = new_salary
    }
    override def tax: Double =
      0.2 * _salary.toDouble
  }
  trait Teacher extends Worker {
    override def tax = 0.1 * _salary
  }

  abstract class Osoba_2(
      val name: String,
      val surname: String
  ) {
    def tax(): Double
  }
  var person_1 = new Osoba_2("Michał", "Szpak") with Student
  var person_2 = new Osoba_2("Adam", "Małysz") with Worker
  person_2.salary = 2000
  var person_3 = new Osoba_2("Jerzy", "Urban") with Teacher
  var person_4 = new Osoba_2("Mariusz", "Pudzianowski") with Student with Worker
  var person_5 = new Osoba_2("Anna", "Walentynowicz") with Worker with Student
  person_4.salary = 1500
  person_5.salary = 3000

  def print_person(person: Osoba_2): Unit = {
    println(s"${person.name} tax : ${person.tax}")
  }
  print_person(person_1)
  print_person(person_2)
  print_person(person_3)
  print_person(person_4)
  print_person(person_5)
}