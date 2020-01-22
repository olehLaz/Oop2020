package ua.multithreadedprog.synchronizedmethod;

public class TransactionSync extends Thread{
    private AccountSync accountSync;
    private int amount;

    public TransactionSync(AccountSync accountSync, int amount) {
        this.accountSync = accountSync;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 500);
        } catch (InterruptedException e) {
            return;
        }
        accountSync.withdraw(amount);
    }
}
