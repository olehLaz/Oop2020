package ua.home.filewatcher605;

public class Notifier implements Runnable {
    private FileWatcher fileWatcher;

    public Notifier(FileWatcher fileWatcher) {
        this.fileWatcher = fileWatcher;
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        String name = th.getName();
        for (;!th.isInterrupted();) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(fileWatcher.infoFlag()) {
                System.out.println(name + " starting");

                try {
                    Thread.sleep(1000);
                    synchronized (fileWatcher) {
                        fileWatcher.notifyAll();
                        fileWatcher.flag = false;
                        System.out.println(name + " thread Notifier worked");
                        fileWatcher.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
