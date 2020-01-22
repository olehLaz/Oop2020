package ua.multithreadedprog.synchronized1;

public class Sample5 {
    public static void main(String[] args) {
        Account account = new Account(1000);

        Transaction[] transactions = {
          new Transaction(account, 100),
          new Transaction(account, 500),
          new Transaction(account, 200),
          new Transaction(account, 50),
          new Transaction(account, 150)
        };
        for (Transaction tr : transactions)
            tr.start();
        for (Transaction tr : transactions) {
            try {
                tr.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total left:  " + account.getMoney());

    }
}
