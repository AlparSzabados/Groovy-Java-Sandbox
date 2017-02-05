package szabados.alpar.exercises.euler

import org.junit.Test

class Euler_09 {

    /**
     * <strong>Problem 9: Special Pythagorean triplet</strong>
     * <p>
     * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
     * a<sup>2</sup> + b<sup>2</sup> = c<sup>2</sup>
     * <p>
     * For example, 3<sup>2</sup> + 4<sup>2</sup> = 9 + 16 = 25 = 5<sup>2</sup>.
     * <p>
     * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
     * Find the product productOfABC.
     * <p>
     * See also <a href="https://projecteuler.net/problem=9">projecteuler.net problem 9</a>.
     */

    @Test
    public void shouldSolveProblem9() {
        assert productOfABC(1_000) == 31_875_000
    }

    private static int productOfABC(int sum) {
        (1..sum).findResult { a ->
            (a..sum).findResult { b ->
                int c = sum - a - b
                if (a**2 + b**2 == c**2 && c > b && a + b + c == sum) {
                    a * b * c
                }
            }
        }
    }
}
