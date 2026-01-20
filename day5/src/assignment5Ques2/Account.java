package assignment5Ques2;
public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void addAmount(double amount) {
        double temp = balance;
        temp = temp + amount;
        balance = temp;
    }

    public void subtractAmount(double amount) {
        double temp = balance;
        temp = temp - amount;
        balance = temp;
    }
// Ques 2 part B
//If Synchronized keyword is used then this part have to be 
//implemented and the above one should be commented 
//    public void addAmount(double amount) {
//        synchronized (this) {
//            balance = balance + amount;
//        }
//    }
//
//    public void subtractAmount(double amount) {
//        synchronized (this) {
//            balance = balance - amount;
//        }
//   }

}



