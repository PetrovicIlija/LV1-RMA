class Player(
    val playerName: String,
) {
    var dice: MutableList<Dice> = mutableListOf(Dice(), Dice(), Dice(), Dice(), Dice())
    var score = 0
    private fun gotYahtzee(): Boolean {
        for (i in 1..4) {
            if (dice[i].numeral != dice[i - 1].numeral)
                return false
        }
        return true
    }

    private fun gotSmallStraight(): Boolean {
        var straight = true
        dice.sortBy { it.isLocked }
        for (i in 1..3)
            if (dice[i].numeral - dice[i - 1].numeral != 1) {
                straight = false
                break
            }
        if (straight) return true
        for (i in 2..4)
            if (dice[i].numeral - dice[i - 1].numeral != 1) {
                straight = false
                break
            }
        if (straight) return true
        return false
    }

    private fun gotFourOfAKind(): Boolean {
        var howMany = 0
        for (i in 0..4) {
            for (j in 0..4)
                if (dice[i].numeral == dice[j].numeral)
                    howMany++
            if (howMany == 4) {
                return true
            }
            howMany = 0
        }
        return false
    }

    fun rollDice() {
        for (diceToRoll in dice)
            diceToRoll.roll()
    }

    fun lockDice(whichDiceToLock: String) {
        val whichDice = whichDiceToLock.split(" ")
        for (i in 0 until 5) {
            if (whichDice[i] == "0")
                dice[i].lockDice()
            else if (dice[i].isLocked)
                dice[i].unlockDice()
        }
    }

    fun calculateScore() {
        if (gotYahtzee())
            this.score += 50
        else if (gotSmallStraight())
            this.score += 30
        else if (gotFourOfAKind()) {
            var sum = 0
            for (diceToCount in dice)
                sum += diceToCount.numeral
            this.score += sum
        }
    }

}


