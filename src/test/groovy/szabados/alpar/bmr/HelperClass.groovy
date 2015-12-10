package szabados.alpar.bmr

class HelperClass {
    static almostEqual(Number result, Number expectedResult) {
        Math.abs(result - expectedResult) < 0.1
    }
}
