package ua.multithreadedprog.executorarray1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Sample11 {
    static final int THREADS_COUNT = 4;
    static final int PART_LENGTH = 10_000_000;

    public static void main(String[] args) {
        int[] array = new int[THREADS_COUNT * PART_LENGTH];
        Arrays.fill(array, 1);

        ExecutorService service = Executors.newFixedThreadPool(THREADS_COUNT);
        CompletionService<Long> completionService = new ExecutorCompletionService<>(service);

        int offset = 0;
        long result = 0;
        try {
            for (int i = 0; i < THREADS_COUNT; i++) {
                Counter counter = new Counter(array, offset, offset + PART_LENGTH);
                offset += PART_LENGTH;

                completionService.submit(counter);
            }
            for (int i=0; i<THREADS_COUNT; i++) {
                try {
                    Future<Long> future = completionService.take();
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
