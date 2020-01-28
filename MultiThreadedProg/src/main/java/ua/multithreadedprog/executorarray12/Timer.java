package ua.multithreadedprog.executorarray12;

public class Timer implements Runnable {
    @Override
    public void run() {
        System.out.println("Tick");
    }
}
