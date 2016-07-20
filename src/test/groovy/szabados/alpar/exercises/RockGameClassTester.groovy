package szabados.alpar.exercises

import szabados.alpar.exercises.RpsGame

import static szabados.alpar.exercises.RpsGame.gameWinner
import static szabados.alpar.exercises.RpsGame.GamePossibilities.*
import static szabados.alpar.exercises.RpsGame.GameResults.*

// Prompts the player to input choice to begin game.
println "Rock, Paper or Scissors?"

RpsGame.GamePossibilities playerChoice = playerInput()

// The player choice is read from the console.
def playerInput() {
    def playerChoice = System.in.newReader().readLine().toUpperCase()
    println "Your choose: ${playerChoice}"
    playerChoice
}

RpsGame.GamePossibilities computerChoice = computerInput()

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





