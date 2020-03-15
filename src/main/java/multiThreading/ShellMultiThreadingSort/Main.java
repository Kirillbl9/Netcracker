package multiThreading.ShellMultiThreadingSort;

import java.util.Random;

public class Main {

    public static void main(String[] args) {


        Random rn = new Random();
        int[] array = new int[100000];
        int cenr = array.length / 2;
        int[] part1 = new int[cenr];
        int[] part2;
        if (cenr * 2 != array.length) {
            part2 = new int[cenr + 1];
        } else part2 = new int[cenr];

        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(100);
            if (i < cenr) {
                part1[i] = array[i];
            }
            else {
                part2[i - cenr] = array[i];
            }
        }

        try {
            long start = System.currentTimeMillis();
            MultithreadedShellSorting mss = new MultithreadedShellSorting(part1, part2);
            mss.getThr().join();
            array = mss.getArray();
            long end = System.currentTimeMillis();
            System.out.println("Multithreaded Shell sorting.\nTime: " + (end - start) + "ms. Array length is " + array.length);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void shell(int[] array) {
        int length = array.length;
        int semi = length / 2;
        while (semi > 0) {
            for (int i = 0; i < length - semi; i++) {
                int j = i;
                while ((j >= 0) && array[j] > array[j + semi]) {
                    int temp = array[j];
                    array[j] = array[j + semi];
                    array[j + semi] = temp;
                    j--;
                }
            }
            semi /= 2;
        }
    }

}
