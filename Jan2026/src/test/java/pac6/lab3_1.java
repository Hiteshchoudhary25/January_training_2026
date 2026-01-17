package pac6;

import java.util.Scanner;
class NameException extends Exception{
	NameException(String msg){
		super(msg);
	}
}

public class lab3_1 {
	static void validateName(String firstName , String lastName) throws NameException {
		if(firstName.isBlank() || lastName.isBlank()) {
			throw new NameException("First  Name and Last Name cannot be blank");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first Name :");
		String firstName = sc.next();

		System.out.println("Enter last Name :");
		String lastName = sc.next();
		
		try {
			validateName(firstName , lastName);
			System.out.println("Valid Full Name ");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
