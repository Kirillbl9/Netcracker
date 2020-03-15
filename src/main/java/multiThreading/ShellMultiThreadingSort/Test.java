package multiThreading.ShellMultiThreadingSort;


public class Test {
    private static volatile int count = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j <100 ; j++) {
                   count++;
                }
            }
            ).start();
        }
        System.out.println(count);
    }
}
