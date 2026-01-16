package pac5;

public class lab2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person smith = new Person("Smith" , 30);
		Person kathy = new Person("kathy" , 28);
		
		Account smithAccount = new Account(smith , 2000);
		Account kathyAccount = new Account(kathy ,3000);
		
		smithAccount.deposit(2000);
		kathyAccount.withdraw(2000);
		
		System.out.println("Account Details :");
		System.out.println(smithAccount);
		System.out.println(kathyAccount);

	}

}
