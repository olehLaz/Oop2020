package ua.multithreadedprog.interrupts;

public class TestThread3 implements Runnable {
    @Override
    public void run() {
        for(;!Thread.currentThread().isInterrupted();) {
            System.out.println(" ua.multithreadedprog.interrupts ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
