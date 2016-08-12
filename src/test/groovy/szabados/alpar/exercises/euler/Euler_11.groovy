package szabados.alpar.exercises.euler

class Euler_11 {
    static greatestProductOfAdjacentNumbersInAGrid(List<List<Integer>> grid, int sizeOfConsecutive) {
        def maxProductOfRightAndDown = rightAndDown(grid, sizeOfConsecutive)
        def maxProductOfDiagonalRight = diagonalRight(grid, sizeOfConsecutive)
        def maxProductOfDiagonalLeft = diagonalLeft(grid, sizeOfConsecutive)

        [maxProductOfRightAndDown, maxProductOfDiagonalRight, maxProductOfDiagonalLeft].max()
    }

    static rightAndDown(List<List<Integer>> grid, int sizeOfConsecutive) {
        def maxRightAndDown = 0
        for (k in 0..<grid.size()) {
            for (i in 0..(grid.size() - sizeOfConsecutive)) {
                def horizontal = 1
                def vertical = 1
                for (int j = i; j < (i + sizeOfConsecutive); j++) {
                    horizontal *= grid[k][j]
                    vertical *= grid[j][k]
                }
                maxRightAndDown = (horizontal > vertical) ? horizontal : vertical
            }
        }
        maxRightAndDown
    }


    static diagonalRight(List<List<Integer>> grid, int sizeOfConsecutive) {
        def maxDiagonalRight = 0
        for (k in 0..(grid.size() - sizeOfConsecutive)) {
            for (i in 0..(grid.size() - sizeOfConsecutive)) {
                def result = 1
                def x = 0
                for (int j = k; j < k + sizeOfConsecutive; j++) {
                    result *= grid[j][i + x]
                    x++
                }
                if (result > maxDiagonalRight)
                    maxDiagonalRight = result
            }
        }
        maxDiagonalRight
    }

    static diagonalLeft(List<List<Integer>> grid, int sizeOfConsecutive) {
        def maxDiagonalLeft = 0
        for (k in 0..(grid.size() - sizeOfConsecutive)) {
            for (i in (sizeOfConsecutive - 1)..<grid.size()) {
                def result = 1
                def x = 0
                for (int j = k; j < k + sizeOfConsecutive; j++) {
                    result *= grid[j][i + x]
                    x--
                }
                if (result > maxDiagonalLeft)
                    maxDiagonalLeft = result
            }
        }
        maxDiagonalLeft
    }
}