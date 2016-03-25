package szabados.alpar.exercises

/** Zero out the row an column of each 0 element in a matrix */

//TODO Take care of the warnings

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

        for (row in matrix) {
            row[matrixColumn] = 0
        }

        for (number in 0..(matrix[0].size() - 1)) {
            matrixRow.each { int rowNumber ->
                matrix[rowNumber][number] = 0
            }
        }
        matrix
    }
}