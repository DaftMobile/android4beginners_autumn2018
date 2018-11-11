package android4beginners1

fun main(args: Array<String>) {
    // listy
    val cities: MutableList<String> = mutableListOf("Warszawa", "Londyn", "Madryt")
    cities.add("Rzym")
    // zbiory
    val set = mutableSetOf("Red")
    // tablice
    val array = arrayOf("Hallo")
    // tablice typów prostych
    val intArray = intArrayOf(1)
    // mapy i pary
    val pair = "elo" to 3
    val triple = Triple(1, "jeden", 1f)
    val map = mapOf(
            Pair(1, "Jeden"),
            Pair(2, "Dwa"),
            3 to "Trzy"
    )
    println(cities)
    // for with range
    for (i in 10 until 1 step 2) {
        println(i)
    }
    // repeat
    repeat(5) {
        println("10")
    }
}