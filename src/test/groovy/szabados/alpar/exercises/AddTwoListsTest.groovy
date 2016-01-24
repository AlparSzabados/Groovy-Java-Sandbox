package szabados.alpar.exercises

import spock.lang.Specification

class AddTwoListsTest extends Specification {
    /*@formatter:off*/
    def 'Add two list of numbers'() {
        when:   def numberList = AddTwoLists.addTwoLists(numList1, numList2)
        then:   numberList == result.toString()

        where:  numList1       | numList2 || result
                1              | 2        || 3
                10             | 2        || 12
                12             | 1234     || 1246
                1234           | 12       || 1246
                9999           | 1        || 10000
                987            | 123      || 1110
                1              | 99       || 100
                3141592653     | 589793   || 3142182446
        /*@formatter:off*/
    }
}