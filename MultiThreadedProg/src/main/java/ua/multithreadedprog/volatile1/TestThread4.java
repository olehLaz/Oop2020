package ua.multithreadedprog.volatile1;

public class TestThread4 extends Thread {
    private volatile boolean stop;

    @Override
    public void run() {
        for(;!stop;) {
            System.out.println("ua.multithreadedprog.volatile1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }

        }
    }
    public void myInterrupt() {
        stop = true;
    }
}
