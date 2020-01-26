package ua.multithreadedprog.increment1;

public class TestThread extends Thread {
    private final Counter counter;

    public TestThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(System.currentTimeMillis() % 100); // от 0 до 99

        } catch (InterruptedException e) {
            return;
        }
        counter.increment();
    }
}
