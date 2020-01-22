package ua.multithreadedprog.pushpull;

public class Action {
    private boolean turn;

    public Action() {
    }

    public Action(boolean turn) {
        this.turn = turn;
    }
    public  synchronized void getText(String text, boolean turn) {
        for(;this.turn == turn;) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(text + "   ");
        this.turn = !this.turn;
        notifyAll();
    }
}
