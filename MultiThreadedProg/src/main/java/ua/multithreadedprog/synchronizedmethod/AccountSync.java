package ua.multithreadedprog.synchronizedmethod;

public class AccountSync {
    private int money;

    public AccountSync(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public synchronized void withdraw(int amount) {
        if (money >= amount)
            money -= amount;
    }
    //или
    //synchronized (this) {
   //     if (money >= amount)
  //          money -= amount;
  //  }

}
