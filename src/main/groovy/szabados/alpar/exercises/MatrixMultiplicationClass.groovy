package szabados.alpar.exercises

/* Write a program to takes two matrix(3*3) array as inputs and calculate the multiplication of both matrix. */

class MatrixMultiplicationClass {
    static MultiplyMatrix(ArrayList<Integer> matrixOne, ArrayList<Integer> matrixTwo) {

        def result = new int[3][3]

        def sum = 0
        for (k in 0..2) {
            for (i in 0..2) {
                for (j in 0..2) {
                    sum += matrixOne[k][j] * matrixTwo[j][i]
                }
                result[k][i] = sum
                sum = 0
            }
        }
        result
    }
}

