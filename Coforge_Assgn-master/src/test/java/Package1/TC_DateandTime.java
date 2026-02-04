package Package1;


import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class TC_DateandTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Instant currenttime= Instant.now();
     System.out.println("Current time is: "+currenttime);
     LocalDate now= LocalDate.now();
     LocalDate Independence= LocalDate.of(1947, Month.AUGUST,15);
     Period period =Independence.until(now);
     System.out.println("Days"+period.get(ChronoUnit.DAYS));
     System.out.println("Days"+period.get(ChronoUnit.MONTHS));
     System.out.println("Days"+period.get(ChronoUnit.YEARS));
     
     
     System.out.println("Independence:"+Independence);
		System.out.println("Tomorrow:"+now.plusDays(1));
		System.out.println("LastMonth:"+now.minusMonths(1));
		System.out.println("Leap Year?:"+now.isLeapYear());
		System.out.println("move to 30th day of month:"+now.withDayOfMonth(30));
		
		ZonedDateTime ct= ZonedDateTime.now();
		ZonedDateTime ctinparis= ZonedDateTime.now(ZoneId.of("Europe/Paris"));
System.out.println("'India time"+ct);
System.out.println("Paris time"+ctinparis);

DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("dd/MM/yyyy");

System.out.println("India time (formatted): " + ct.format(formatter1));
 

	}

}
