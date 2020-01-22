package ua.multithreadedprog.volatile1;

public class Sample4 {
    public static void main(String[] args) {
        TestThread4 thread = new TestThread4();
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.myInterrupt();
    }
}
