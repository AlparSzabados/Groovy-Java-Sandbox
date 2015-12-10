package szabados.alpar.numberConversion

class NumberConversion {

    /**
     * Converts binary numbers into decimal numbers
     * @param binNumber binary number to be converted
     * @return as decimal number
     */
    static binaryConversion(int binNumber) {
        def result = 0
        def offset = 0
        while (binNumber > 0) {
            result += (binNumber % 10) * 2**offset
            offset += 1
            binNumber /= 10
        }
        result
    }

    /**
     * Converts decimal numbers into binary numbers
     * @param decNumber decimal number to be converted
     * @return as binary number
     */
    static decimalConversion(int decNumber) {
        def result = 0
        def offset = 1
        while (decNumber > 0) {
            result += (decNumber % 2) * offset
            offset *= 10
            decNumber /= 2
        }
        result
    }
}