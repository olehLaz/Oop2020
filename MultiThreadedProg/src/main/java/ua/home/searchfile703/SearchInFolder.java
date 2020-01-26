package ua.home.searchfile703;

import java.io.File;

public class SearchInFolder implements Runnable {
    private File[] files;
    private SearchFile searchFile;

    public SearchInFolder(File[] files, SearchFile searchFile) {
        this.files = files;
        this.searchFile = searchFile;
    }

    @Override
    public void run() {
        searchFile.searching(files);
    //    System.out.println(" SearchInFolder  " + Thread.currentThread().getClass().getName());

    }
}
