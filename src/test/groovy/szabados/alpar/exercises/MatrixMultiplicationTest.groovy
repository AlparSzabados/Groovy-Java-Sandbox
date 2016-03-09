package szabados.alpar.exercises

import spock.lang.Specification

import static MatrixMultiplicationClass.*

class MatrixMultiplicationTest extends Specification {
    def "MultiplyMatrix"() {
        /* formatter: off */
        when:   def result = MultiplyMatrix(matrixOne, matrixTwo)
        then:   result == expectedResult

        where:  matrixOne                         | matrixTwo                        || expectedResult
                [[1, 2, 3], [4, 5, 6], [7, 8, 1]] | [[1, 2, 3], [3, 2, 1], [4, 5, 2]] || [[19, 21, 11], [43, 48, 29], [35, 35, 31]]
    }
    /* formatter: on */
}
