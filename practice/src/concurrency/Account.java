package concurrency;

class Account{

    public int getBalance() {
        return balance;
    }

    private int balance=10000;
    public static void transfer(Account acc1, Account acc2, int amount){
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }

    public void withdraw(int amount){
        balance-=amount;
    }
    public void deposit(int amount){
        balance+=amount;
    }
}
