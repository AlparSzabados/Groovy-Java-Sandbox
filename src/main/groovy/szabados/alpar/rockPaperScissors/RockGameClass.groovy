package szabados.alpar.rockPaperScissors

import static szabados.alpar.rockPaperScissors.RockGameClass.GamePossibilities.*
import static szabados.alpar.rockPaperScissors.RockGameClass.GameResults.*

class RockGameClass {
    enum GamePossibilities {
        ROCK, PAPER, SCISSORS
    }

    enum GameResults {
        COMPUTER_WINS, PLAYER_WINS, TIE
    }

    static gameWinner(GamePossibilities computerChoice, GamePossibilities playerChoice) {
        if (computerChoice == ROCK && playerChoice == SCISSORS) {
            COMPUTER_WINS
        } else if (computerChoice == ROCK && playerChoice == PAPER) {
            PLAYER_WINS
        } else if (computerChoice == SCISSORS && playerChoice == PAPER) {
            COMPUTER_WINS
        } else if (computerChoice == SCISSORS && playerChoice == ROCK) {
            PLAYER_WINS
        } else if (computerChoice == PAPER && playerChoice == ROCK) {
            COMPUTER_WINS
        } else if (computerChoice == PAPER && playerChoice == SCISSORS) {
            PLAYER_WINS
        } else {
            TIE
        }
    }
}

