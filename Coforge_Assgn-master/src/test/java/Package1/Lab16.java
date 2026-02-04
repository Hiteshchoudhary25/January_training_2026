
package Package1;

public class Lab16 {

   
    static class Person {
        private String name;
        private float age;

        public Person() {}

        public Person(String name, float age) {
            this.name = name;
            this.age = age;
        }

   
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public float getAge() { return age; }
        public void setAge(float age) { this.age = age; }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

   
    static class Account {
        private long accNum;
        private double balance;
        private Person accHolder;

        public static final double MIN_BALANCE = 500.0;

        public Account() {}

        public Account(long accNum, Person accHolder, double openingBalance) {
            this.accNum = accNum;
            this.accHolder = accHolder;
            
            this.balance = Math.max(openingBalance, MIN_BALANCE);
        }

        
        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Deposit amount must be positive.");
                return;
            }
            balance += amount;
        }

       
        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
                return;
            }
            if (balance - amount < MIN_BALANCE) {
                System.out.println("Withdrawal denied: minimum balance of INR "
                        + MIN_BALANCE + " must be maintained.");
                return;
            }
            balance -= amount;
        }

        public double getBalance() { return balance; }

        
        public long getAccNum() { return accNum; }
        public void setAccNum(long accNum) { this.accNum = accNum; }

        public Person getAccHolder() { return accHolder; }
        public void setAccHolder(Person accHolder) { this.accHolder = accHolder; }

        public void setBalance(double balance) {
           
            this.balance = Math.max(balance, MIN_BALANCE);
        }

        @Override
        public String toString() {
            return "Account{accNum=" + accNum + ", balance=" + balance +
                    ", accHolder=" + (accHolder != null ? accHolder.getName() : "null") + "}";
        }
    }

 
    public static void main(String[] args) {
        Person holder = new Person("Dipanshu", 21.0f);

        
        Account acc = new Account(1234567890123L, holder, 400); 
        System.out.println("Opening balance: " + acc.getBalance());

        acc.deposit(800);
        System.out.println("After deposit: " + acc.getBalance());

        acc.withdraw(700);
        System.out.println("After withdrawal: " + acc.getBalance());

        acc.withdraw(600); 
        System.out.println("Final balance: " + acc.getBalance());
    }
}

