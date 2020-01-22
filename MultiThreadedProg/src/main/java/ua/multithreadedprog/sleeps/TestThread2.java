package ua.multithreadedprog.sleeps;

public class TestThread2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted!!!");
        }
        System.out.println("Hi, I'm  " + this.getClass().getName());
    }
}
