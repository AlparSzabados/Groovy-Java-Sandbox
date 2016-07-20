package szabados.alpar.exercises

/** Zero out the row and column of each 0 element in a matrix */

class ZeroOutMatrix {
    static zeroOutMatrix(matrix) {
        def matrixColumn = []
        def matrixRow = []

        matrix.eachWithIndex { row, i ->
            row.eachWithIndex { number, j ->
                if (number == 0) {
                    matrixColumn << j
                    matrixRow << i
                }
            }
        }

        for (row in matrix) {
            row[matrixColumn] = 0
        }

        for (int i in 0..(matrix[0].size() - 1)) {
            matrixRow.each { int rowNumber ->
                matrix[rowNumber][i] = 0
            }
        }
        matrix
    }
}