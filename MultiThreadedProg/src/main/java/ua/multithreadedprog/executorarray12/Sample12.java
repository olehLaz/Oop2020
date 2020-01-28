package ua.multithreadedprog.executorarray12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Sample12 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service =  Executors.newScheduledThreadPool(1);
        try{
            service.scheduleWithFixedDelay(new Timer(), 5, 3, TimeUnit.SECONDS);
            Thread.sleep(20000);
        } finally {
            service.shutdownNow();
        }
    }
}
