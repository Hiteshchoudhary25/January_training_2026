
package Package1;

public class Lab_2_2 {

    static class Person {
        String name;
        float age;

        Person(String name, float age) {
            this.name = name;
            this.age = age;
        }
    }

    static abstract class Account {
        static long nextAccNo = 1001;
        long accNo;
        double balance;
        Person holder;

        Account(Person holder, double balance) {
            this.accNo = nextAccNo++;
            this.holder = holder;
            this.balance = balance;
        }

        void deposit(double amt) {
            balance += amt;
        }

        abstract boolean withdraw(double amt);

        public String toString() {
            return "AccNo: " + accNo +
                   ", Name: " + holder.name +
                   ", Balance: " + balance;
        }
    }

    static class SavingsAccount extends Account {
        static final double MIN_BALANCE = 500;

        SavingsAccount(Person holder, double balance) {
            super(holder, balance < MIN_BALANCE ? MIN_BALANCE : balance);
        }

        boolean withdraw(double amt) {
            if (balance - amt >= MIN_BALANCE) {
                balance -= amt;
                return true;
            }
            return false;
        }
    }

    static class CurrentAccount extends Account {
        double overdraft;

        CurrentAccount(Person holder, double balance, double overdraft) {
            super(holder, balance);
            this.overdraft = overdraft;
        }

        boolean withdraw(double amt) {
            if (balance - amt >= -overdraft) {
                balance -= amt;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {

        Person smith = new Person("Smith", 30);
        Person kathy = new Person("Kathy", 28);

        SavingsAccount smithAcc = new SavingsAccount(smith, 2000);
        CurrentAccount kathyAcc = new CurrentAccount(kathy, 1000, 500);

        smithAcc.deposit(2000);
        kathyAcc.withdraw(1200);

        System.out.println("\nUpdated Account Details:");
        System.out.println("Smith → " + smithAcc);
        System.out.println("Kathy → " + kathyAcc);
    }
}
