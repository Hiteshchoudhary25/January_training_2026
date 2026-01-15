package pac4;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class lab14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Zone id :");
		String zone = sc.nextLine();
		
		ZonedDateTime datetime = ZonedDateTime.now(ZoneId.of(zone));
		
		System.out.println("Current Date & Time in :" + datetime);

	}

}
