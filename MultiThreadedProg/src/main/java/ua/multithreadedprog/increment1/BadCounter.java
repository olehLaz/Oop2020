package ua.multithreadedprog.increment1;

public class BadCounter implements Counter {
    //volatile обеспечивает синхронизацию только чтения или только записи
    private volatile int x;

    @Override
    public void increment() {
        x++;
    }
    @Override
    public String toString() {
        return "Counter = " + x;
    }
}
