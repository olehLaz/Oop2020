package ua.home.filewatcher605;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File folder = new File(".");

        FileWatcher fileWatcher = new FileWatcher(folder);

        Waiter waiter = new Waiter(fileWatcher);
        new Thread(waiter,"waiter").start();


        Notifier notifier = new Notifier(fileWatcher);
        new Thread(notifier, "notifier").start();
        System.out.println("Стартовали все потоки");
    }
}
