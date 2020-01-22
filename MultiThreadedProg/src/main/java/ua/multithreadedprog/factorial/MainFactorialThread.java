package ua.multithreadedprog.factorial;

import sun.applet.Main;

public class MainFactorialThread {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new FactorialThread(5));
        Thread threadTwo = new Thread(new FactorialThread(6));
        Thread threadTree = new Thread(new FactorialThread(7));
        threadOne.start();
        threadTwo.start();
        threadTree.start();
        try {
            threadOne.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" isInterrupted  = " + threadOne.isInterrupted() + " для " + threadOne.getName());
        System.out.println(" isAlive  = " + threadOne.isAlive() + " для " + threadOne.getName());
        System.out.println(Thread.currentThread().getName() + "  Остановлен ");
    }
}
