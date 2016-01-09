package szabados.alpar.rockPaperScissors

import static szabados.alpar.rockPaperScissors.RockGameClass.gameWinner
import static szabados.alpar.rockPaperScissors.RockGameClass.GamePossibilities.*
import static szabados.alpar.rockPaperScissors.RockGameClass.GameResults.*

println "Rock, Paper or Scissors?" // Prompts the player to input choice to begin game.

def playerChoice = playerInput()
def playerInput() {
    RockGameClass.GamePossibilities playerChoice = System.in.newReader().readLine().toUpperCase()
    println "Your choose: ${playerChoice}"
    playerChoice
}

// Randomly generates a choice for the computer.
def computerChoice = computerInput()
def computerInput() {
    def list = [ROCK, PAPER, SCISSORS]
    def random = new Random()
    def possibilities = list[random.nextInt(list.size())]
    def computerChoice = possibilities
    println "Computer choose : ${computerChoice}"
    computerChoice
}

def winner = gameWinner(computerChoice, playerChoice)
switch (winner) {
    case COMPUTER_WINS: println "The computer won this time!"
        break;
    case PLAYER_WINS: println "You won this round!"
        break;
    case TIE: println "It's a tie! Nobody wins!"
        break;
}





