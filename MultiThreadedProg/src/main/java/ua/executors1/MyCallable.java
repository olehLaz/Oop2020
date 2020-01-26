package ua.executors1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
/*
в Java 5 был введен интерфейс  java.util.concurrent.Callable. Он очень похож на интерфейс Runnable,
но может вернуть результат в виде объекта Object и способен бросать исключения.
Интерфейс Callable использует дженерики для определения типа возвращаемого объекта. Класс Executors предоставляет
полезные методы для выполнения Callable в пуле потоков. Callable таски (задачи) возвращают java.util.concurrent.Future объект.
Используя Future мы можем узнать статус Callable таска и получить возвращенный объект.
Это обеспечивает get() метод, который ждет завершение Callable, чтобы вернуть результат.
Future обеспечивает метод cancel() для отмены Callable таска. Есть перегруженный вариант метода get(),
где мы можем указать время ожидания результата, это нужно для избежания блокировки текущего потока на длительное время.
Также есть методы isDone() и isCancelled(), которые используются для получения статуса ассоциированного Callable таска.
 */

public class MyCallable implements Callable<String> {
    public static void main(String[] args) {
        //Получаем ExecutorService утилитного класса Executors с размером gпула потоков равному 10
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //создаем список с Future, которые ассоциированы с Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        // создаем экземпляр MyCallable
        Callable<String> callable = new MyCallable();
        for (int i = 0; i < 100; i++) {
            //сабмитим Callable таски, которые будут
            //выполнены пулом потоков
            Future<String> future = executorService.submit(callable);
            //добавляя Future в список,
            //мы сможем получить результат выполнения
            list.add(future);
        }
        for (Future<String> fut : list) {
            try {
                // печатаем в консоль возвращенное значение Future
                // будет задержка в 1 секунду, потому что Future.get()
                // ждет пока таск закончит выполнение
                System.out.println("::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName() +"   " + new Date();
    }

}
