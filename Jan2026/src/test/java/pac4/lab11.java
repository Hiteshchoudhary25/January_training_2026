package pac4;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class lab11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date : (YYYY-MM-DD)");
		String date = sc.nextLine();
		
		LocalDate startDate = LocalDate.parse(date);
		LocalDate currentDate = LocalDate.now();
		Period duration = Period.between(startDate , currentDate);
		
		System.out.println("Duration from " + startDate + " to " + currentDate + " is:");
	    System.out.println(duration.getYears() + " Years");
	    System.out.println(duration.getMonths() + " Months");
	    System.out.println(duration.getDays() + " Days");
	    sc.close();
	}

}
