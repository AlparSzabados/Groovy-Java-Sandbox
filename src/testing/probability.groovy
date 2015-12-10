def decimalConversion(int decNumber) {
    def result2 = 0
    while (decNumber > 0) {
        result2 += (decNumber % 2)
        decNumber /= 2
    }
    println result2
}


def number = decimalConversion(2)