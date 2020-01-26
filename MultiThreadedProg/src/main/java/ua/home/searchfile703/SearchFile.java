package ua.home.searchfile703;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SearchFile implements Runnable {

    private String search;
    private File path;
    private File[] files;
    private ExecutorService service;
    private List<Thread> threadList;
    private List<File> foundList;

    public SearchFile(String search, File path) {
        this.search = search;
        this.path = path;
        files = path.listFiles();
        foundList = new ArrayList<File>();
        threadList = new ArrayList<Thread>();
        service = Executors.newScheduledThreadPool(4);
        service.submit(this);



    }

    public void searching(File[] files) {
        if(files == null)
            return;
        for (File f : files) {
            if(f.isDirectory()) {
                service.submit(new SearchInFolder(f.listFiles(), this));
                threadList.add(Thread.currentThread());
            }
            if (f.isFile() && f.getName().equalsIgnoreCase(search)) {
                System.out.format("%s has found %s\n", Thread.currentThread().getName(), f.getName());
                foundList.add(f);
                for (File ff : foundList) {
                    System.out.println(ff.getAbsoluteFile());
                }
            }
        }
    }

    @Override
    public void run() {
        searching(files);


        try {
            service.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (foundList.size() == 0) {
            System.out.println(Thread.currentThread() + "Nothing was found!");
        }

        service.shutdown();
    }
}
