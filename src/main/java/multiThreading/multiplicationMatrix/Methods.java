package multiThreading.multiplicationMatrix;

import java.util.Random;

public class Methods {
    public static int[][] randomMatrix(int[][] matrix)
    {
        final Random random = new Random();
        for (int row = 0; row < matrix.length; ++row)
            for (int col = 0; col < matrix[row].length; ++col)
                matrix[row][col] = random.nextInt(100);
        return matrix;
    }
    public static void printMatrix(int[][] matrix){
        for (final int[] row : matrix) {
            for (final int element : row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static int[][] multiplyMatrix(int[][] firstMatrix,
                                          int[][] secondMatrix)
    {
        final int rowCount = firstMatrix.length;
        final int colCount = secondMatrix[0].length;
        final int sumLength = secondMatrix.length;
        final int[][] result = new int[rowCount][colCount];

        for (int row = 0; row < rowCount; ++row) {
            for (int col = 0; col < colCount; ++col) {
                int sum = 0;
                for (int i = 0; i < sumLength; ++i)
                    sum += firstMatrix[row][i] * secondMatrix[i][col];
                result[row][col] = sum;
            }
        }
        return result;
    }
}
