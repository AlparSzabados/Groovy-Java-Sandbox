package szabados.alpar.exercises

import spock.lang.Specification
import szabados.alpar.exercises.RpsGame

import static szabados.alpar.exercises.RpsGame.GamePossibilities.*
import static szabados.alpar.exercises.RpsGame.GameResults.*

/**
 *  Test for the Rock, Paper, Scissors Game.
 */
class RpsGameTest extends Specification {
/*@formatter:off*/
    def 'Rps game check winner'() {
        when:   def gameResults = RpsGame.gameWinner(computerChoice, playerChoice)
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

