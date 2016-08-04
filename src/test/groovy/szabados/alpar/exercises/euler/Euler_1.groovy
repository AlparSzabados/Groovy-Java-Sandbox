package szabados.alpar.exercises.euler

import org.junit.Test

import static szabados.alpar.exercises.euler.Utils.isDivisible

class Euler_1 {

    /**
     * <strong>Problem 1: Multiples of 3 and 5</strong>
     * <p>
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
     * The sum of these multiples is 23.
     * <p>
     * Find the sum of all the multiples of 3 or 5 below 1000.
     * <p>
     * See also <a href="https://projecteuler.net/problem=1">projecteuler.net problem 1</a>.
     */
    @Test

    public void shouldSolveProblem1() {
        assert sumOf3and5bellow(10) == 23
        assert sumOf3and5bellow(1000) == 233_168
    }

    private static int sumOf3and5bellow(int limit) {
        (1..<limit).findAll { filter it }.sum() as int
    }

    private static boolean filter(int num) {
        isDivisible(num, 3) || isDivisible(num, 5)
    }
}