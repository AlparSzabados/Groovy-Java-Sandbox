package szabados.alpar.exercises

import spock.lang.Specification

class QuizTests extends Specification {
    def 'dollars and cents'() {
        when:   def dollars = ConvertToCurrency.convertToDollars(values)
        then:   dollars == result

        where:  values       || result
                "3"          || "\$3.00"
                "3.1"        || "\$3.10"
                "3.99"       || "\$3.99"
    }

    def 'timed reading'() {
        when:   def wordsRead = WordsRead.wordsRead(maxLength, string)
        then:   wordsRead == result

        where:  maxLength | string                                         || result
                4         | "The Fox asked the stork, 'How is the soup?'"  || 7
    }

    def 'volleyball positions'() {
        when:   def initialFormation = VolleyballRotation.getInitialPosition(formation as String[][], k)
        then:   initialFormation == result

        where:  formation                                                                                                               | k   || result
                [["empty","Player5","empty"],["Player4","empty","Player2"],["empty","Player3","empty"],["Player6","empty","Player1"]]   | 2   || [["empty","Player1","empty"],["Player2","empty","Player3"],["empty","Player4","empty"],["Player5","empty","Player6"]]
                [["empty","Alice","empty"],["Bob","empty","Charlie"],["empty","Dave","empty"],["Eve","empty","Frank"]]                  | 6   || [["empty","Alice","empty"],["Bob","empty","Charlie"],["empty","Dave","empty"],["Eve","empty","Frank"]]
    }

    def 'unique ordering'() {
        when:   def uniqueOrdering = OrderUnique.uniqueOrder(string)
        then:   uniqueOrdering == result

        where:  string            || result
                'AAAABBBCCDAABBB' || ['A', 'B', 'C', 'D', 'A', 'B']
                'ABBCcAD'         || ['A', 'B', 'C', 'c', 'A', 'D']
                '1,2,2,3,3'       || ['1', '2', '3']
    }
}
