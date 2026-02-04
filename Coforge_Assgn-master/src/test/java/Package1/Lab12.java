package Package1;

import java.time.LocalDate;
import java.time.Period;
 
public class Lab12 {
 
    public static void main(String[] args) {
 
       
        LocalDate date1 = LocalDate.of(2020, 5, 10);
        LocalDate date2 = LocalDate.of(2024, 12, 25);
 
        printDuration(date1, date2);
    }
 
    public static void printDuration(LocalDate start, LocalDate end) {
        
        if (start.isAfter(end)) {
            LocalDate temp = start;
            start = end;
            end = temp;
        }
 
        Period period = Period.between(start, end);
 
        System.out.println("Duration between dates:");
        System.out.println("Years  : " + period.getYears());
        System.out.println("Months : " + period.getMonths());
        System.out.println("Days   : " + period.getDays());
    }
}
