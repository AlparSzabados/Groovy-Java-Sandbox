package szabados.alpar.exercises

import spock.lang.Specification
import static szabados.alpar.exercises.NumberConversion.*

/**
 * Test for binary number conversion to decimal and decimal to binary
 */
class NumberConversionTest extends Specification {
    /*@formatter:off*/
    def 'convert binary to decimal'() {
        when:   def decimalNumber = convertedNumber(binNumber)
        then:   decimalNumber == result

        where:  binNumber        || result
                '0b0'            || 0
                '0b1'            || 1
                '0b10'           || 2
                '0b11'           || 3
                '0b100'          || 4
                '0b101'          || 5
                '0b110'          || 6
                '0b111'          || 7
                '0b1000'         || 8
                '0b1001'         || 9
                '0b1010'         || 10
                '0b1011'         || 11
                '0b1100'         || 12
                '0b1101'         || 13
                '0b1110'         || 14
                '0b1111'         || 15
                '0b10000'        || 16
                '0b1011110001'   || 753
                '0b101011010'    || 346
                '0b1010110101'   || 693
                '0b1111111111'   || 1023

                0                || '0b0'
                1                || '0b1'
                2                || '0b10'
                3                || '0b11'
                4                || '0b100'
                5                || '0b101'
                6                || '0b110'
                7                || '0b111'
                8                || '0b1000'
                9                || '0b1001'
                10               || '0b1010'
                11               || '0b1011'
                12               || '0b1100'
                13               || '0b1101'
                14               || '0b1110'
                15               || '0b1111'
                16               || '0b10000'
                753              || '0b1011110001'
                346              || '0b101011010'
                693              || '0b1010110101'
                1023             || '0b1111111111'
    }
    /*@formatter:on*/
}
