package ua.multithreadedprog.runthreads;

public class Sample1 {
    public static void main(String[] args) {
        //1
        Test1 thread1 = new Test1();
        //thread1.setDaemon(true);
        thread1.setPriority(Thread.MAX_PRIORITY); //1-10
        thread1.start();
        //2
        Thread thread2 = new Thread(new Test2());
        thread2.start();
        //3 анонимный класс
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi, I'm thread from Runnable " + this.getClass().getName());
            }
        });
        thread3.start();

        //4 Лямбда 1.8
        Runnable task4 = () -> {
            System.out.println("Hi, I'm thread from Runnable task4 " + Thread.currentThread().getName());
        };
        new Thread(task4).start();

        System.out.println(" Finish !!!  " + Thread.currentThread().getName());
    }
}
