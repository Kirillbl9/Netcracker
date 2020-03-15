package multiThreading.multiplicationMatrix;

import static multiThreading.multiplicationMatrix.Methods.multiplyMatrix;
import static multiThreading.multiplicationMatrix.Methods.randomMatrix;

public class OneThread{
    public static void main(String[] args) {
        int m = 1000;
        int n = 1000;
        int a[][] = new int[m][n];
        int b[][] = new int[m][n];
        int res[][] = new int[m][n];
      //  printMatrix(randomMatrix(a));
      //  printMatrix(randomMatrix(b));
        long time = System.currentTimeMillis();
        multiplyMatrix(randomMatrix(a), randomMatrix(b));
        System.out.println("Calculate time: " + (System.currentTimeMillis() - time) + " ms");
    }
}
