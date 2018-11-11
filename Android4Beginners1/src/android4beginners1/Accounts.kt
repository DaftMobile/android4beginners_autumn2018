package android4beginners1


// Klasy i metody są domyślnie final
// Należy użyć słowa kluczowego open, żeby można je było rozszerzyć/nadpisać
open class PersonalAccount(private var balance: Int) {
    open fun withdraw(amount: Int) {
        balance -= amount
    }
}

class SavingsAccount(balance: Int) : PersonalAccount(balance) {
    override fun withdraw(amount: Int) {
        super.withdraw(amount + FEE)
    }

    // W tym bloku podajemy static
    companion object {
        private var FEE: Int = 3
    }
}
