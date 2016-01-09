package szabados.alpar.rockPaperScissors

import spock.lang.Specification
import static szabados.alpar.rockPaperScissors.RockGameClass.GamePossibilities.*
import static szabados.alpar.rockPaperScissors.RockGameClass.GameResults.*

/**
 *  Test for the Rock, Paper, Scissors Game.
 */
class RockGameClassTest extends Specification {
/*@formatter:off*/
    def 'Rock, Paper, Scissors Game'() {
        when:   def gameResults = RockGameClass.gameWinner(computerChoice, playerChoice)
        then:   gameResults == winner

        where:  computerChoice | playerChoice || winner
                PAPER          | ROCK         || COMPUTER_WINS
                ROCK           | SCISSORS     || COMPUTER_WINS
                SCISSORS       | PAPER        || COMPUTER_WINS
                ROCK           | PAPER        || PLAYER_WINS
                SCISSORS       | ROCK         || PLAYER_WINS
                PAPER          | SCISSORS     || PLAYER_WINS
                PAPER          | PAPER        || TIE
                SCISSORS       | SCISSORS     || TIE
                ROCK           | ROCK         || TIE
    }
    /*@formatter:on*/
}

