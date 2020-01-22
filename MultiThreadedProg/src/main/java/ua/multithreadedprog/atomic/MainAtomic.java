package ua.multithreadedprog.atomic;

public class MainAtomic {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        for(int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SingleThread(someClass));
            thread.start();
        }
    }
}
