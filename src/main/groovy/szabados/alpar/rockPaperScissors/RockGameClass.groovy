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
        if (computerChoice == playerChoice)
            TIE
        else if (computerChoice.next() == playerChoice)
            PLAYER_WINS
        else
            COMPUTER_WINS
    }
}

