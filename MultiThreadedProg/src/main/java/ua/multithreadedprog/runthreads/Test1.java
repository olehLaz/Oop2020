package ua.multithreadedprog.runthreads;

public class Test1 extends Thread {
    @Override
    public void run() {
        System.out.println("Hi, I'm thread from extends Thread " + this.getClass().getName());
    }
}
