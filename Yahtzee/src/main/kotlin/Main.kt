import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    println("Welcome! How many players are going to play?")
    val howManyPlayers = Integer.parseInt(reader.nextLine())
    val players: MutableList<Player> = mutableListOf()
    for (player in 1..howManyPlayers) {
        println("Player $player, enter your nickname for the game.")
        players.add(Player(reader.nextLine()))
    }
    for (i in 0..12) {
        println()
        println("Round ${i + 1}!")
        println()
        for (player in 0 until howManyPlayers) {
            println("${players[player].playerName},  these are the rolls!")
            players[player].rollDice()
            for (dice in players[player].dice)
                print("${dice.numeral} ")
            println()
            println(
                "${players[player].playerName}, choose which dice to keep by marking them with 0, " +
                        "and marking them with 1 if you want to reroll them. Separate numbers using spaces."
            )
            players[player].lockDice(reader.nextLine())
            println("${players[player].playerName},  these are the rolls!")
            players[player].rollDice()
            for (dice in players[player].dice)
                print("${dice.numeral} ")
            println()
            println(
                "${players[player].playerName}, choose which dice to keep by marking them with 0, " +
                        "and marking them with 1 if you want to reroll them"
            )
            players[player].lockDice(reader.nextLine())
            println("${players[player].playerName}, these are the rolls!")
            players[player].rollDice()
            for (dice in players[player].dice)
                print("${dice.numeral} ")
            println()
            players[player].calculateScore()
            println("${players[player].playerName}, you scored ${players[player].score} so far!")
        }
    }
}