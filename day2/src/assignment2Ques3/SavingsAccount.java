package assignment2Ques3;

public class SavingsAccount extends Account {

    private static final double INTEREST_RATE = 5.0;
    private static final double MIN_BALANCE = 5000.0;

    public SavingsAccount(String name, String accountNumber, double initialBalance) {
        super(name, accountNumber, initialBalance);

        if (initialBalance < MIN_BALANCE) {
            throw new IllegalArgumentException("Initial balance must be at least ₹5000.");
        }
    }

    @Override
    public double getBalance() {
        return accountBalance + (accountBalance * INTEREST_RATE / 100);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (amount > accountBalance) {
            System.out.println("Withdrawal exceeds available balance.");
            return;
        }

        if ((accountBalance - amount) < MIN_BALANCE) {
            System.out.println("Cannot withdraw. Minimum balance of ₹5000 must be maintained.");
            return;
        }

        accountBalance -= amount;
        System.out.println("Withdrawn ₹" + amount + " from Savings Account");
    }
}
