package szabados.alpar.exercises.euler

import org.junit.Test

class Euler_6 {

    /**
     * <strong>Problem 6: Sum square difference</strong>
     * <p>
     * The sum of the squares of the first ten natural numbers is,
     * <p>
     * 1² + 2² + ... + 10² = 385
     * <p>
     * The square of the sum of the first ten natural
     * numbers is,
     * <p>
     * (1 + 2 + ... + 10)² = 55² = 3025
     * <p>
     * Hence the difference between the sum of the
     * squares of the first ten natural numbers and the square of the sum is
     * <p>
     * 3025 − 385 = 2640.
     * <p>
     * Find the difference between the sum of the squares of the first one hundred
     * natural numbers and the square of the sum.
     * <p>
     * See also <a href="https://projecteuler.net/problem=6">projecteuler.net problem 6</a>.
     */
    @Test
    public void shouldSolveProblem6() {
        assert differenceBetweenSumOfTheSquaresAndSquareOfTheSumFrom1UpTo(10) == 2640
        assert differenceBetweenSumOfTheSquaresAndSquareOfTheSumFrom1UpTo(100) == 25_164_150
    }

    private static long differenceBetweenSumOfTheSquaresAndSquareOfTheSumFrom1UpTo(int max) {
        return squareOfSumFrom1UpTo(max) - sumOfSquaresFrom1UpTo(max);
    }

    static long sumOfSquaresFrom1UpTo(int max) {
        (1..max).inject { result, n -> result + n**2 }
    }

    static long squareOfSumFrom1UpTo(int max) {
        ((max * (max + 1)) / 2)**2
    }
}