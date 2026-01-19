package assignment2Ques3;

public class CurrentAccount extends Account {

    private String tradeLicenseNumber;
    private double overdraftLimit;

    public CurrentAccount(String name, String accountNumber, double initialBalance,
                          String tradeLicenseNumber, double overdraftLimit) {
        super(name, accountNumber, initialBalance);
        this.tradeLicenseNumber = tradeLicenseNumber;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double getBalance() {
        return accountBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > accountBalance + overdraftLimit) {
            System.out.println("Withdrawal exceeds overdraft limit.");
            return;
        }

        accountBalance -= amount;
        System.out.println("Withdrawn ₹" + amount + " from Current Account");
    }

    public String getTradeLicenseNumber() {
        return tradeLicenseNumber;
    }
}
