package pac4;

import java.time.LocalDate;
import java.util.Scanner;

public class lab13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter purchase date : (YYYY-MM-DD)");
		LocalDate purchaseDate = LocalDate.parse(sc.nextLine());
		
		System.out.println("Enter warrant years :");
		int years = sc.nextInt();
		
		System.out.println("Enter warranty months :");
		int months = sc.nextInt();
		
		LocalDate expiryDate = purchaseDate.plusYears(years).plusMonths(months);
		
		System.out.println("Warranty Expiry Date :" + expiryDate);
		sc.close();	

	}

}
