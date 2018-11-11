package android4beginners1.locals

class PolishPluralsLocale(val one: String, val few: String, val other: String): Locale {

    // When w odróżnieniu od switch nie potrzebuje break-ów i nie musi przyjmować argumentu
    // Zastępuje w ten sposób złożone if-else'y
    // No i może zwracać wartość
    override fun localize(amount: Int) = when {
        amount == 1 -> one
        amount % 100 in 11..20 -> other
        amount % 10 in 2..4 -> few
        else -> other
    }
}