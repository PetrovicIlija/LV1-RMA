import kotlin.random.Random

class Dice {
    var isLocked: Boolean = false
    var numeral: Int = 0
    fun roll() {
        if (!this.isLocked)
            numeral = Random.nextInt(1, 6)
    }

    fun lockDice() {
        isLocked = true
    }

    fun unlockDice() {
        isLocked = false
    }
}
