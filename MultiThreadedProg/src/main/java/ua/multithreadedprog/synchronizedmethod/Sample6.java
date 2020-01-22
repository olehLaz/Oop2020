package ua.multithreadedprog.synchronizedmethod;

public class Sample6 {
    public static void main(String[] args) {
        AccountSync account = new AccountSync(1000);

        TransactionSync[] transactions = {
                new TransactionSync(account, 100),
                new TransactionSync(account, 500),
                new TransactionSync(account, 200),
                new TransactionSync(account, 50),
                new TransactionSync(account, 150)
        };
        for (TransactionSync tr : transactions)
            tr.start();
        for (TransactionSync tr : transactions) {
            try {
                tr.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total left:  " + account.getMoney());

    }
}
