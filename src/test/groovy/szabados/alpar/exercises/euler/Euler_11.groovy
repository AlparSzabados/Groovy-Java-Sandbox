package szabados.alpar.exercises.euler

import static szabados.alpar.exercises.euler.Utils.createMatrix

class Euler_11 {
    static greatestProductOfAdjacentNumbersInAGrid(String st, int sizeOfConsecutive) {
        def matrix = createMatrix(st)
        def maxHorizontal = horizontal(matrix, sizeOfConsecutive)
        def maxVertical = vertical(matrix, sizeOfConsecutive)
        def maxDiagonalUp = diagonalUp(matrix, sizeOfConsecutive)
        def maxDiagonalDown = diagonalDown(matrix, sizeOfConsecutive)

        [maxHorizontal, maxVertical, maxDiagonalUp, maxDiagonalDown].max()
    }

    static horizontal(List<String> matrix, int sizeOfConsecutive) {
        def maxHorizontal = 0
        for (int k in 0..<matrix.size()) {
            for (int i in 0..<matrix.size() - sizeOfConsecutive + 1) {
                def result = 1
                for (int j = i; j < (i + sizeOfConsecutive); j++) {
                    result *= matrix[k][j].toInteger()
                }
                if (result > maxHorizontal)
                    maxHorizontal = result
            }
        }
        maxHorizontal
    }

    static vertical(List<String> matrix, int sizeOfConsecutive) {
        def maxVertical = 0
        for (int k in 0..<matrix.size()) {
            for (int i in 0..<matrix.size() - sizeOfConsecutive + 1) {
                def result = 1
                for (int j = i; j < i + sizeOfConsecutive; j++) {
                    result *= matrix[j][k].toInteger()
                }
                if (result > maxVertical) {
                    maxVertical = result
                }
            }
        }
        maxVertical
    }

    static diagonalUp(List<String> matrix, int sizeOfConsecutive) {
        def maxDiagonalUp = 0
        for (int k in 0..matrix.size() - sizeOfConsecutive) {
            for (int i in 0..matrix.size() - sizeOfConsecutive) {
                def result = 1
                def x = 0
                for (int j = k; j < k + sizeOfConsecutive; j++) {
                    result *= matrix[j][i + x].toInteger()
                    x++
                }
                if (result > maxDiagonalUp) {
                    maxDiagonalUp = result
                }
            }
        }
        maxDiagonalUp
    }

    static diagonalDown(List<String> matrix, int sizeOfConsecutive) {
        def maxDiagonalDown = 0
        for (int k in 0..matrix.size() - sizeOfConsecutive) {
            for (int i in 3..<matrix.size()) {
                def result = 1
                def x = 0
                for (int j = k; j < k + sizeOfConsecutive; j++) {
                    result *= matrix[j][i + x].toInteger()
                    x--
                }
                if (result > maxDiagonalDown) {
                    maxDiagonalDown = result
                }
            }
        }
        maxDiagonalDown
    }
}

