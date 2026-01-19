package assignment2Ques3;
public abstract class Account {

    private String name;
    private String accountNumber;
    protected double accountBalance;

    public Account(String name, String accountNumber, double accountBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        accountBalance += amount;
        System.out.println("Deposited Rs " + amount);
    }

    public abstract void withdraw(double amount);

    public abstract double getBalance();

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
