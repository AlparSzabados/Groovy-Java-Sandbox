package szabados.alpar.exercises

/** Zero out the row an column of each 0 element in a matrix */

class Matrix {
    static zeroOutMatrix(matrix) {
        def matrixColumn = []
        def matrixRow = []
        matrix.eachWithIndex { row, rowIndex ->
            row.eachWithIndex { number, columnIndex ->
                if (number == 0) {
                    matrixColumn << columnIndex
                    matrixRow << rowIndex
                }
            }
        }

        for (i in matrix) {
            i[matrixColumn] = 0
        }

        for (i in 0..matrix[0].size() - 1) {
            matrixRow.each { int rowNumber ->
                matrix[rowNumber][i] = 0
            }
        }
        matrix
    }
}