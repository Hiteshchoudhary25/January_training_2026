package pac6;

import java.util.Scanner;

class AgeException extends Exception{
	AgeException(String msg){
		super(msg);
	}
}

public class lab3_2 {
	static void validateAge(int age) throws AgeException{
		if(age <= 15) {
			throw new AgeException("Age Must be Above 15");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Age :");
			int age = sc.nextInt();
			
			validateAge(age);
			System.out.println("Valid Age . Age approved");
		}catch(AgeException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
