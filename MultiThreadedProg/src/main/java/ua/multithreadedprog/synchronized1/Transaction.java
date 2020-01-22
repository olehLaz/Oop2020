package ua.multithreadedprog.synchronized1;

public class Transaction extends Thread {
    private Account account;
    private int withdraw;

    public Transaction(Account account, int withdraw) {
        this.account = account;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 500); //от 0 до 499 мс
        } catch (InterruptedException e) {
            return;
        }
        synchronized (account) { //comment this line
            int total = account.getMoney();
            if(total >= withdraw) {
                account.setMoney(total - withdraw);
            }
        } // comment this line
    }
}
