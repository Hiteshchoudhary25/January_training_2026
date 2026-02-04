package Package1;
 
import java.util.*;
 
public class Lab_3_2 {
    
    public static class AgeValidationException extends Exception {
        public AgeValidationException(String message) {
            super(message);
        }
    }
 
    public static class Person {
        private String name;
        private float age;
 
        public Person(String name, float age) throws AgeValidationException {
            this.name = name;
            validateAge(age);
            this.age = age;
        }
 
        public String getName() {
            return name;
        }
 
        public void setName(String name) {
            this.name = name;
        }
 
        public float getAge() {
            return age;
        }
 
        public void setAge(float age) throws AgeValidationException {
            validateAge(age);
            this.age = age;
        }
 
        private void validateAge(float age) throws AgeValidationException {
            if (age <= 15) {
                throw new AgeValidationException("Invalid age: " + age + ". Age must be above 15.");
            }
        }
    }
    
    public static class Account {
        private String accNum;
        private double balance;
        private Person accHolder;
 
        private static final double MIN_BALANCE = 500.0;
 
        public Account() {}
 
        public Account(String accNum, Person accHolder, double balance) {
            this.accNum = accNum;
            this.accHolder = accHolder;
 
            if (balance >= MIN_BALANCE) {
                this.balance = balance;
            } else {
                this.balance = MIN_BALANCE;
                System.out.println("Minimum balance ₹500 maintained.");
            }
        }
 
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }
 
        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
                return;
            }
            if (balance - amount >= MIN_BALANCE) {
                balance -= amount;
            } else {
                System.out.println("Withdrawal denied! Minimum balance ₹500 must be maintained.");
            }
        }
        
        public static String generate() {
            long time = System.currentTimeMillis();
            int random = new Random().nextInt(900) + 100;
            return time + "" + random;
        }
 
        public double getBalance() {
            return balance;
        }
 
        public String getAccNum() {
            return accNum;
        }
 
        public void setAccNum(String accNum) {
            this.accNum = accNum;
        }
 
        public Person getAccHolder() {
            return accHolder;
        }
 
        public void setAccHolder(Person accHolder) {
            this.accHolder = accHolder;
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
 
            System.out.print("Enter age: ");
            float age = sc.nextFloat();
 
            Person p = new Person(name, age);
 
            Account a = new Account();
            String ac = a.generate();
 
            Account acc = new Account(ac, p, 1000);
 
            System.out.print("Enter deposit amount: ");
            double depositAmt = sc.nextDouble();
            acc.deposit(depositAmt);
 
            System.out.println("Balance: " + acc.getBalance());
 
            System.out.print("Enter withdrawal amount: ");
            double withdrawAmt = sc.nextDouble();
            acc.withdraw(withdrawAmt);
 
            System.out.println("Final Balance: " + acc.getBalance());
            System.out.println("Account Number: " + ac);
 
        } catch (AgeValidationException ave) {
            System.out.println("Error: " + ave.getMessage());
            System.out.println("Account creation failed due to invalid age.");
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input type. Please enter numbers for age and amounts.");
        } finally {
            sc.close();
        }
    }
}