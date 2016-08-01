package szabados.alpar.exercises

import spock.lang.Specification

import static szabados.alpar.exercises.Sort.*

class SortTest extends Specification {
    /*@formatter:off*/
    def 'should sort list of Integers'() {
        when:   def result = sortListOfIntegers(list)
        then:   result == sortedList

        where:  list                                        ||  sortedList
                []                                          || []
                [1, 2]                                      || [1, 2]
                [1, 1, 1, 1]                                || [1, 1, 1, 1]
                [1, 2, 3, 9, 1000, 0, 99, 8, 7, 7, 1, 0, 0] || [0, 0, 0, 1, 1, 2, 3, 7, 7, 8, 9, 99, 1000]
    }
    /*@formatter:on*/
}
