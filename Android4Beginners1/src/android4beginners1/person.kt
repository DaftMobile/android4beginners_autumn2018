package android4beginners1

class Person(val name: String, var age: Int, var job: Job?) {

    fun birthday() {
        age += 1
    }

    fun isOfAge() = age >= 18

    fun timeTravel(years: Int) {
        age += years
    }

    fun income() = job?.salary ?: 0
}

data class Job(val salary: Int)

fun Person.isEmployed(): Boolean = job != null

fun main(args: Array<String>) {
    var a: Int = 8
    var b: String = "Hallo"
    var c: Boolean = true
    b = "World"
    val d = 10

    val iosDev: Person = Person("Michał", 28, Job(1000))
    val androidDev: Person = Person("Konrad", 26, Job(1000))

    println(iosDev.job == androidDev.job)

    val point = Point(5f, 5f)
    point.x += 100f
    println(point)
}
