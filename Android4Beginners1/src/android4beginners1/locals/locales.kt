package android4beginners1.locals

fun main(args: Array<String>) {
    val locale: Locale = PolishPluralsLocale("samochód", "samochody", "samochodów")
    val testCases = listOf(0, 1, 4, 5, 12, 15, 22, 25, 112)
    for (case in testCases) {
        println("Mam $case ${locale.localize(case)}")  // String template
    }

    println((locale as? EnglishPluralsLocale)?.one)
}