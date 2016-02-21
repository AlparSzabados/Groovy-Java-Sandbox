package szabados.alpar.exercises

import spock.lang.Specification

import static AddTwoNumbers.addTwoNumbers

class AddTwoNumbersTest extends Specification {
    /*@formatter:off*/
    def 'Add two list of numbers'() {
        when:   def numberList = addTwoNumbers(num1, num2)
        then:   numberList == result.toString()

        where:  num1       | num2     || result
                1          | 2        || 3
                10         | 2        || 12
                12         | 1234     || 1246
                1234       | 12       || 1246
                9999       | 1        || 10000
                987        | 123      || 1110
                1          | 99       || 100
                3141592653 | 589793   || 3142182446
        /*@formatter:off*/
    }
}