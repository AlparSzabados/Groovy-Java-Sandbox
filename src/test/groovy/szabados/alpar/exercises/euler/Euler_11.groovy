package szabados.alpar.exercises.euler

class Euler_11 {
    static greatestProductOfAdjacentNumbersInAGrid(List grid, int sizeOfConsecutive) {
        def maxHorizontal = rightAndDown(grid, sizeOfConsecutive)
        def maxDiagonalUp = diagonalRight(grid, sizeOfConsecutive)
        def maxDiagonalDown = diagonalLeft(grid, sizeOfConsecutive)

        [maxHorizontal, maxDiagonalUp, maxDiagonalDown].max()
    }

    static rightAndDown(List<List<Integer>> grid, int sizeOfConsecutive) {
        def maxHorizontalAndVertical = 0
        for (k in 0..<grid.size()) {
            for (i in 0..(grid.size() - sizeOfConsecutive)) {
                def horizontal = 1
                def vertical = 1
                for (int j = i; j < (i + sizeOfConsecutive); j++) {
                    horizontal *= grid[k][j]
                    vertical *= grid[j][k]
                }
                maxHorizontalAndVertical = (horizontal > vertical) ? horizontal : vertical
            }
        }
        maxHorizontalAndVertical
    }


    static diagonalRight(List<List<Integer>> matrix, int sizeOfConsecutive) {
        def maxDiagonalUp = 0
        for (int k in 0..(matrix.size() - sizeOfConsecutive)) {
            for (int i in 0..(matrix.size() - sizeOfConsecutive)) {
                def result = 1
                def x = 0
                for (int j = k; j < k + sizeOfConsecutive; j++) {
                    result *= matrix[j][i + x]
                    x++
                }
                if (result > maxDiagonalUp) {
                    maxDiagonalUp = result
                }
            }
        }
        maxDiagonalUp
    }

    static diagonalLeft(List<List<Integer>> matrix, int sizeOfConsecutive) {
        def maxDiagonalDown = 0
        for (int k in 0..matrix.size() - sizeOfConsecutive) {
            for (int i in 3..<matrix.size()) {
                def result = 1
                def x = 0
                for (int j = k; j < k + sizeOfConsecutive; j++) {
                    result *= matrix[j][i + x]
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