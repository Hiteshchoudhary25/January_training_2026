package pac5;

public class Account {
	private static long accCounter = 1001;
	private long accNum;
	private double balance;
	private Person accHolder;
	
	private static final double MIN_BALANCE = 500.0;
	
	public Account(Person accHolder , double initialBalance) {
		this.accNum = accCounter++;
		this.accHolder = accHolder;
		
		if(initialBalance >= MIN_BALANCE) {
			this.balance = initialBalance;
		}else {
			this.balance = MIN_BALANCE;
			System.out.println("Initial balance Low");
		}
		
	}
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
		}
	}
	
	public void withdraw(double amount) {
		if(balance - amount >= MIN_BALANCE) {
			balance -= amount;
		}else {
			System.out.println("Withdrawl denied");
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
//	public long getAccNum{
//		return accNum;
//	}
	
	public Person getAccHolder() {
		return accHolder;
	}

	@Override
	public String toString() {
		return "Account [ Account Number = " + accNum + " , Holder = " + accHolder.getName() + " , Balance = " + balance + "]";
	}

}
