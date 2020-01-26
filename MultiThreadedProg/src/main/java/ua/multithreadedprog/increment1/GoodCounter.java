package ua.multithreadedprog.increment1;

import java.util.concurrent.atomic.AtomicInteger;

public class GoodCounter implements Counter{
    private AtomicInteger x = new AtomicInteger();

    @Override
    public void increment() {
        x.getAndIncrement();
    }

    @Override
    public String toString() {
        return "Counter = " + x.get();
    }
}
