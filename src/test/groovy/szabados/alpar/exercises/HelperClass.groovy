package szabados.alpar.exercises

class HelperClass {
    static almostEqual(Number result, Number expectedResult) {
        Math.abs(result - expectedResult) < 0.1
    }
}
