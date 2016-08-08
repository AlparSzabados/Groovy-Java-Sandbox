package szabados.alpar.exercises

import spock.lang.Specification

class TwoMaxTest extends Specification {
    def 'should find the two maximums'() {
        /*@formatter:off*/
        when: def result = TwoMax.findTwoMax(list)
        then: result == twoMax

        where: list                           || twoMax
               [1]                            || [1]
               [1, 1]                         || [1, 1]
               [1, 3, 2, 3]                   || [3, 3]
               [1, 3, 2, 3, 10, 9]            || [9, 10]
               [9, 3, 2, 3, 1, 10]            || [9, 10]
               [3, 1, 4, 1, 5, 9, 2, 6, 5, 3] || [6, 9]
        /*@formatter:on*/
    }
}
