package android4beginners1


class PersonalAccount(private var balance: Int) {
    fun withdraw(amount: Int) {
        balance -= amount
    }
}
