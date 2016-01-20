package szabados.alpar.exercises

/** Zero out the row an column of each 0 element in a matrix */

// TODO write a method that actually changes the rows and columns

def matrix = [[0, 0, 3], [4, 1, 2]]
//column: 0  1  2
//row: 0 [0, 0, 3]
//row: 1 [4, 1, 2]

matrix.eachWithIndex { row, rowIndex ->
    row.eachWithIndex { number, columnIndex ->
        if (number == 0) {
            println "column: ${columnIndex} row: ${rowIndex}" // prints the location of Zeros in the matrix
        }
    }
}



