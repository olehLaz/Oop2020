package ua.multithreadedprog.clock;

public class MainClockThread {
    public static void main(String[] args) {
        Thread thr = new Thread(new KillerThread());
        thr.start();
    }
}
