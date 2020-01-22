package ua.multithreadedprog.pushpull;

public class MainPushPullThread {
    public static void main(String[] args) {


        Action action = new Action();

        PushPullThread push = new PushPullThread("Push", action, true);
        PushPullThread pull = new PushPullThread("Pull", action, false);//если и сдесь поставить true будет блокировка deadlock
        Thread pushThread = new Thread(push);
        Thread pullThread = new Thread(pull);

        pushThread.start();
        pullThread.start();


    }
}
