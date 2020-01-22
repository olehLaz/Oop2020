package ua.multithreadedprog.filecopier;

public class MainCopyFiles {
    public static void main(String[] args) {
        String readFromDir = "c:\\Users\\lazovoyov\\Documents\\111\\12\\";
        String writeToDir = "c:\\Users\\lazovoyov\\Documents\\111\\";

        MultiCopier.multithreadCopier(readFromDir, writeToDir, 1);



    }
}
