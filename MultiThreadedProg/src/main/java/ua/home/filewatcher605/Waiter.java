package ua.home.filewatcher605;

import java.text.SimpleDateFormat;

public class Waiter implements Runnable {
    private FileWatcher fileWatcher;

    public Waiter(FileWatcher fileWatcher) {
        this.fileWatcher = fileWatcher;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy   hh:mm:ss");
        for(;!Thread.currentThread().isInterrupted();) {
            synchronized (fileWatcher) {
                try{
                    System.out.println(name + " ждем вызов метода notify: " + sdf.format(System.currentTimeMillis()));
                    fileWatcher.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(name + " был вызов метода notify: " + sdf.format(System.currentTimeMillis()));
                fileWatcher.info();
                fileWatcher.flag = false;
                fileWatcher.notifyAll();
            }

        }
    }


}
