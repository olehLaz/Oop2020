package ua.multithreadedprog.executorarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sample10 {
    static final int THREADS_COUNT = 4;
    static final int PART_LENGTH = 10_000_000;

    public static void main(String[] args) {
        int[] array = new int[THREADS_COUNT * PART_LENGTH];
        Arrays.fill(array, 1);
        ExecutorService service = Executors.newFixedThreadPool(THREADS_COUNT);
        List<Future<Long>> results = new ArrayList<>();
        int offset = 0;
        long result = 0;
        try {
            for (int i = 0; i < THREADS_COUNT; i++) {
                Counter counter = new Counter(array, offset, offset + PART_LENGTH);
                offset += PART_LENGTH;

                Future<Long> future = service.submit(counter);
                results.add(future);

            }
            for (Future<Long> future : results) {
                try {
                    result += future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    return;
                }
            }
            System.out.println(" Result =  " + result);
        } finally {
            service.shutdownNow();
        }
    }
}
