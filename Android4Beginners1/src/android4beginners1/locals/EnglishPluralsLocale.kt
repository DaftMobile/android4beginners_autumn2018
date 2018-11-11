package android4beginners1.locals


class EnglishPluralsLocale(val one: String, val other: String): Locale {

    // If zwraca wartość
    override fun localize(amount: Int) = if (amount == 1) one else other
}