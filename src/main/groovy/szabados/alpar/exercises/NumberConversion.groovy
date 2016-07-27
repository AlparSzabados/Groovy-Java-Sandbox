package szabados.alpar.exercises

class NumberConversion {
    /* Converts the string representation of a binary number into an int in decimal and vice versa. */

    static Object convertedNumber(Object num) {
        def binNumber
        def decNumber

        if (num.toString().startsWith('0b')) {
            decNumber = num.toString()[2..-1].toInteger()
            return convertToBinary(decNumber)
        } else {
            binNumber = num.toString().toInteger()
            return "0b${convertToDecima(binNumber)}"
        }
    }

    static int convertToBinary(int num) {
        def result = 0
        def offset = 0
        while (num > 0) {
            result += (num % 10) * 2**offset
            offset += 1
            num /= 10
        }
        result
    }

    static int convertToDecima(int num) {
        def result = 0
        def offset = 1
        while (num > 0) {
            result += (num % 2) * offset
            offset *= 10
            num /= 2
        }
        result
    }
}