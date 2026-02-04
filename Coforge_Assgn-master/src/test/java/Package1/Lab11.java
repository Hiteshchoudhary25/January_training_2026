
package Package1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Lab11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date (yyyy-mm-dd): ");
        String input = sc.nextLine();

        LocalDate givenDate = LocalDate.parse(input);
        LocalDate today = LocalDate.now();

        Period p = givenDate.until(today);

        System.out.println("Years: " + p.getYears());
        System.out.println("Months: " + p.getMonths());
        System.out.println("Days: " + p.getDays());
    }
}

