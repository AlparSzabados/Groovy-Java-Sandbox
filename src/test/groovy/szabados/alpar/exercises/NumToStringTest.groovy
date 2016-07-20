package szabados.alpar.exercises

import spock.lang.Specification

class NumToStringTest extends Specification {
    /*@formatter:off*/
    def 'Transforming Numbers To String'() {
        when:   def result = NumToString.numToString(numbers)
        then:   result == expectedResult

        where:  numbers ||  expectedResult
                1       ||    "one"
                2       ||    "two"
                3       ||    "three"
                4       ||    "four"
                5       ||    "five"
                6       ||    "six"
                7       ||    "seven"
                8       ||    "eight"
                9       ||    "nine"
                10      ||    "ten"
                11      ||    "eleven"
                12      ||    "twelve"
                13      ||    "thirteen"
                14      ||    "fourteen"
                15      ||    "fifteen"
                16      ||    "sixteen"
                17      ||    "seventeen"
                18      ||    "eighteen"
                19      ||    "nineteen"
                20      ||    "twenty"
                21      ||    "twenty one"
                22      ||    "twenty two"
                30      ||    "thirty"
                40      ||    "forty"
                50      ||    "fifty"
                55      ||    "fifty five"
                60      ||    "sixty"
                70      ||    "seventy"
                80      ||    "eighty"
                90      ||    "ninety"
                99      ||    "ninety nine"
    }
    /*@formatter:on*/
}