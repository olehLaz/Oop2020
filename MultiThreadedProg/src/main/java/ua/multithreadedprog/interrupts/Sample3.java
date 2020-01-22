package ua.multithreadedprog.interrupts;

public class Sample3 {
    public static void main(String[] args) {
        Thread thread = new Thread(new TestThread3());
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println(" Finish !!!  " + Thread.currentThread().getName());

    }
}
