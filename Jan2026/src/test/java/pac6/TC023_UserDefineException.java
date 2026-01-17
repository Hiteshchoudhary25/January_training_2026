package pac6;

import java.util.Scanner;

class AgeException extends Exception{
	private int age;
	AgeException(int a){
		this.age = a;
	}
	public String toString() {
		return age + "is an Invalid age";
	}
}

class emp{
	String name;
	int age;
	
	void getEmpDetails() {
		System.out.println("Enter Your name :");
		Scanner sc =  new Scanner(System.in);
		name = sc.next();
		
		System.out.println("Enter Your age :");
		age = sc.nextInt();
		
		if(age < 16) {
			throw new AgeException(age);
		}
		sc.close();
	}
}

public class TC023_UserDefineException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		emp obj = new emp();
		obj.getEmpDetails();
	}

}
