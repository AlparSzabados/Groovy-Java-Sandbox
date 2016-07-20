package szabados.alpar.exercises
//TODO put it in a Class

def numberOfGames = 10

int computerRolls = 0
int computerWins = 0
int playerRolls = 0
int playerWins = 0
int tiedGames = 0

def rollDice1() {
    Random randValue1 = new Random()
    return randValue1.nextInt(6) + 1
}
def rollDice2() {
    Random randValue2 = new Random()
    return randValue2.nextInt(6) + 1
}

for (round = 0; round < numberOfGames; round++){
    computerRolls = rollDice1() + rollDice2()
    playerRolls = rollDice1() + rollDice2()

    rounds(computerRolls, playerRolls)

    if (computerRolls > playerRolls) {
        computerWins++
    } else if (computerRolls < playerRolls) {
        playerWins++
    } else
        tiedGames++
    [computerWins, playerWins, tiedGames]
}

def rounds(int computerRolls, int playerRolls) {
    println "The computer rolled: ${computerRolls}"
    println "You rolled: ${playerRolls}"
}

println "\n"
println "Computer wins: ${computerWins}"
println "Player wins: ${playerWins}"
println "Ties: ${tiedGames}"

winner(computerWins, playerWins)

def winner(computer, player) {
    if (computer > player) {
        println "\nComputer wins...:("
    } else if (computer < player) {
        println "\nYou WON!"
    } else {
        println "\nIt's a tie"
    }
}


