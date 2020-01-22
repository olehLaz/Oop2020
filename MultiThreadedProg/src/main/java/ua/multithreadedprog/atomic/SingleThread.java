package ua.multithreadedprog.atomic;

public class SingleThread implements Runnable {
    private SomeClass someClass;

    public SingleThread(SomeClass someClass) {
        this.someClass = someClass;
    }

    @Override
    public void run() {
        int x = someClass.volume.getAndIncrement(); //(тоже что и x++)
        System.out.print("  " + x);
    }
}
