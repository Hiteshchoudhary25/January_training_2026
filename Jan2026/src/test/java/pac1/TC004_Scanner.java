package pac1;

import java.util.Scanner;

public class TC004_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int age = sc.nextInt();
		String name = sc.next();
		System.out.println("Your name is : " + name);
		System.out.println("Your age is : " + age);
		
//		sc.close();
		System.out.println("Enter the Number : ");
		int num = sc.nextInt();
		if(num < 0) {
			System.out.println("Negative number");
		}else {
			System.out.println("Positive number");
		}
		
		sc.close();

	}

}
