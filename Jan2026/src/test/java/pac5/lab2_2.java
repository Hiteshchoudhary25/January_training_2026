package pac5;



class Accountt {
    protected int accountNumber;
    protected double balance;
 
    public Accountt(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
 
    // Method to be overridden
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
 
    public double getBalance() {
        return balance;
    }
}
 
// Savings Account
class SavingsAccount extends Accountt {
    // final minimum balance
    private final double minimumBalance = 1000.0;
 
    public SavingsAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }
 
    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("SavingsAccount: Minimum balance must be maintained.");
            return false;
        }
    }
}
 
// Current Account
class CurrentAccount extends Accountt {
    private double overdraftLimit;
 
    public CurrentAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
 
    @Override
    public boolean withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("CurrentAccount: Overdraft limit exceeded.");
            return false;
        }
    }
}
 
// Main class
public class lab2_2 {
    public static void main(String[] args) {
        Accountt savings = new SavingsAccount(101, 5000);
        Accountt current = new CurrentAccount(201, 2000, 3000);
 
        System.out.println("Savings Withdrawal Status: " + savings.withdraw(3500));
        System.out.println("Savings Balance: " + savings.getBalance());
        System.out.println();
 
        System.out.println("Current Withdrawal Status: " + current.withdraw(4500));
        System.out.println("Current Balance: " + current.getBalance());
    }
}
