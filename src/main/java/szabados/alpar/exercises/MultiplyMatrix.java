package szabados.alpar.exercises;

import java.util.Arrays;

public class MultiplyMatrix {
    public static void main(String[] args) {
        {
            int[][] m1 = new int[][]{{1, 2}, {3, 4}};
            int[][] m2 = new int[][]{{5, 6}, {7, 8}};

            System.out.println(Arrays.deepToString(new MultiplyMatrix().multiply(m1, m2)));
        }

        {
            int[][] m1 = new int[][]{{7, 8}};
            int[][] m2 = new int[][]{{1, 2, 3}, {4, 5, 6}};

            System.out.println(Arrays.deepToString(new MultiplyMatrix().multiply(m1, m2)));
        }
    }

    private int[][] multiply(int[][] m1, int[][] m2) {
        int[][] result = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m2[0].length; j++)
                for (int k = 0; k < m2.length; k++)
                    result[i][j] += m1[i][k] * m2[k][j];
        return result;
    }
}
