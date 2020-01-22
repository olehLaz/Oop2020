package ua.multithreadedprog.pushpull;

public class PushPullThread implements Runnable {
    private  String text;
    private Action ac;
    private boolean turn;

    public PushPullThread(String text, Action ac, boolean turn) {
        this.text = text;
        this.ac = ac;
        this.turn = turn;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i+=1) {
            ac.getText(text, turn);
        }
    }
}
