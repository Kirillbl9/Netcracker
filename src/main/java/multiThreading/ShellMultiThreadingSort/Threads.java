package multiThreading.ShellMultiThreadingSort;

public class Threads implements Runnable {

    private int[] array;
    private Thread thr;

    public Threads(int[] array) {
        this.array = array;
        this.thr = new Thread(this);
        thr.start();
    }

    @Override
    public void run() {
        Main.shell(array);
    }

    public Thread getThr() {
        return thr;
    }
}
