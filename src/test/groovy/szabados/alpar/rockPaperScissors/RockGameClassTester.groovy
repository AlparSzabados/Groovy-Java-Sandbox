package szabados.alpar.rockPaperScissors

import static szabados.alpar.rockPaperScissors.RockGameClass.gameWinner
import static szabados.alpar.rockPaperScissors.RockGameClass.GamePossibilities.*
import static szabados.alpar.rockPaperScissors.RockGameClass.GameResults.*

// Prompts the player to input choice to begin game.
println "Rock, Paper or Scissors?"

RockGameClass.GamePossibilities playerChoice = playerInput()

// The player choice is read from the console.
def playerInput() {
    playerChoice = System.in.newReader().readLine().toUpperCase()
    println "Your choose: ${playerChoice}"
    playerChoice
}

RockGameClass.GamePossibilities computerChoice = computerInput()

// The computers choice is generated randomly.
def computerInput() {
    def list = [ROCK, PAPER, SCISSORS]
    def random = new Random()
    def possibilities = list[random.nextInt(list.size())]
    def computerChoice = possibilities
    println "Computer choose : ${computerChoice}"
    computerChoice
}

// Determining the winner.
def winner = gameWinner(computerChoice, playerChoice)
switch (winner) {
    case COMPUTER_WINS: println "The computer won this time!"
        break;
    case PLAYER_WINS: println "You won this round!"
        break;
    case TIE: println "It's a tie! Nobody wins!"
        break;
}





