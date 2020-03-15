package multiThreading.multiplicationMatrix;

import static multiThreading.multiplicationMatrix.Methods.randomMatrix;

public class MultiThread extends Thread {
    public static void main(String[] args) {
        int m = 1000;
        int n = 1000;
        int a[][] = new int[m][n];
        int b[][] = new int[m][n];
        int res[][] = new int[m][n];



        long time = System.currentTimeMillis();
        multiplyMatrixMT(randomMatrix(a), randomMatrix(b), 4);
        System.out.println("Calculate time: " + (System.currentTimeMillis() - time) + " ms");
    }

    private final int[][] firstMatrix;

    private final int[][] secondMatrix;

    private final int[][] resultMatrix;

    private final int firstIndex;

    private final int lastIndex;

    private final int sumLength;

    public MultiThread(final int[][] firstMatrix,
                       final int[][] secondMatrix,
                       final int[][] resultMatrix,
                       final int firstIndex,
                       final int lastIndex) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;

        sumLength = secondMatrix.length;
    }


    public void calcValue(final int row, final int col) {
        int sum = 0;
        for (int i = 0; i < sumLength; ++i)
            sum += firstMatrix[row][i] * secondMatrix[i][col];
        resultMatrix[row][col] = sum;
    }


    @Override
    public void run() {
        final int colCount = secondMatrix[0].length;
        for (int index = firstIndex; index < lastIndex; ++index)
            calcValue(index / colCount, index % colCount);
    }

    private static int[][] multiplyMatrixMT(final int[][] firstMatrix,
                                            final int[][] secondMatrix,
                                            int threadCount) {
        final int rowCount = firstMatrix.length;
        final int colCount = secondMatrix[0].length;
        final int[][] result = new int[rowCount][colCount];

        final int cellsForThread = (rowCount * colCount) / threadCount;
        int firstIndex = 0;
        final MultiThread[] multiplierThreads = new MultiThread[threadCount];

        for (int threadIndex = threadCount - 1; threadIndex >= 0; --threadIndex) {
            int lastIndex = firstIndex + cellsForThread;
            if (threadIndex == 0) {

                lastIndex = rowCount * colCount;
            }
            multiplierThreads[threadIndex] = new MultiThread(firstMatrix, secondMatrix, result, firstIndex, lastIndex);
            multiplierThreads[threadIndex].start();
            firstIndex = lastIndex;
        }
        try {
            for (final MultiThread multiplierThread : multiplierThreads)
                multiplierThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}

