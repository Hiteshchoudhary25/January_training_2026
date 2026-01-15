package pac4;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class lab12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first date : (YYYY-MM-DD)");
		LocalDate firstdate = LocalDate.parse(sc.nextLine());
		
		System.out.println("Enter the second date : (YYYY-MM-DD)");
		LocalDate seconddate = LocalDate.parse(sc.nextLine());
		
		Period diff = Period.between(firstdate, seconddate);
		
		System.out.println("Duration Between : ");
		System.out.println("Years : " + diff.getYears());
		System.out.println("Months :" + diff.getMonths());
		System.out.println("Days :" + diff.getDays());
		
		
		
		

	}

}
