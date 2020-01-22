package ua.multithreadedprog.sleeps;

public class Sample2 {
    public static void main(String[] args) {
        TestThread2 thread = new TestThread2();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" Finish !!!  " + Thread.currentThread().getName());
    }

}
