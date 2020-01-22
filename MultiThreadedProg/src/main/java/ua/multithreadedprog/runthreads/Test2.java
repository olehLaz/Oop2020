package ua.multithreadedprog.runthreads;

public class Test2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Hi, I'm thread from implements Runnable " + this.getClass().getName());
    }
}
