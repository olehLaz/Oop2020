package ua.multithreadedprog.executor1;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sample9 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            Future<BigInteger> future = service.submit(new Calculator(5));
            BigInteger result = null;
            try {
                result = future.get();
                System.out.println(" Result =  " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getCause());
            }
        } finally {
            service.shutdownNow();
        }
    }
}