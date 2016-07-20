package szabados.alpar.exercises

import spock.lang.Specification
import static szabados.alpar.exercises.NumberConversion.*

/**
 * Test for binary number conversion to decimal and decimal to binary
 */
class NumberConversionTest extends Specification {
    /*@formatter:off*/
    def 'Binary Number Conversion'() {
        when:   def decimalNumber = binaryConversion(binNumber)
        then:   decimalNumber == result

        where:  binNumber    || result
                0            || 0
                1            || 1
                10           || 2
                11           || 3
                100          || 4
                101          || 5
                110          || 6
                111          || 7
                1000         || 8
                1001         || 9
                1010         || 10
                1011         || 11
                1100         || 12
                1101         || 13
                1110         || 14
                1111         || 15
                10000        || 16
                1011110001   || 753
                101011010    || 346
                1010110101   || 693
                1111111111   || 1023
    }

    def 'Decimal Number Conversion'() {
        when:   def binaryNumber = decimalConversion(decNumber)
        then:   binaryNumber == result2

        where:  decNumber || result2
                0         || 0
                1         || 1
                2         || 10
                3         || 11
                4         || 100
                5         || 101
                6         || 110
                7         || 111
                8         || 1000
                9         || 1001
                10        || 1010
                11        || 1011
                12        || 1100
                13        || 1101
                14        || 1110
                15        || 1111
                16        || 10000
                753       || 1011110001
                346       || 101011010
                693       || 1010110101
                1023      || 1111111111
    }
    /*@formatter:on*/
}
