package szabados.alpar.rockPaperScissors
//TODO put it in a Class

import static GamePossibilities.*

enum GamePossibilities {
    ROCK, PAPER, SCISSORS
}

println "Rock, Paper or Scissors?"

playerChoice = playerInput()
def GamePossibilities playerInput() {
    GamePossibilities playerChoice = System.in.newReader().readLine().toUpperCase()
    println "Your choose: ${playerChoice}"
    playerChoice
}

computerChoice = computerInput()
def GamePossibilities computerInput() {
    def list = [ROCK, PAPER, SCISSORS]
    def random = new Random()
    def possibilities = list[random.nextInt(list.size())]
    def computerChoice = possibilities
    println "Computer choose : ${computerChoice}"
    computerChoice
}

result(computerChoice, playerChoice)

def result(GamePossibilities computerChoice, GamePossibilities playerChoice) {
    if (computerChoice == ROCK && playerChoice == SCISSORS) {
        println "Computer wins"
    } else if (computerChoice == ROCK && playerChoice == PAPER) {
        println "Player wins"
    } else if (computerChoice == SCISSORS && playerChoice == PAPER) {
        println "Compuer wins"
    } else if (computerChoice == SCISSORS && playerChoice == ROCK) {
        println "Player wins"
    } else if (computerChoice == PAPER && playerChoice == ROCK) {
        println "Computer wins"
    } else if (computerChoice == PAPER && playerChoice == SCISSORS) {
        println "Player wins"
    } else {
        println "It's a tie"
    }
}
