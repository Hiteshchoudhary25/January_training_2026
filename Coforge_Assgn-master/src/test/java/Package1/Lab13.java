package Package1;


import java.time.LocalDate;
import java.util.Scanner;
 
public class Lab13 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter purchase year (yyyy): ");
        int year = sc.nextInt();
 
        System.out.print("Enter purchase month (1-12): ");
        int month = sc.nextInt();
 
        System.out.print("Enter purchase day (1-31): ");
        int day = sc.nextInt();
        System.out.print("Enter warranty period in years: ");
        int warrantyYears = sc.nextInt();
 
        System.out.print("Enter warranty period in months: ");
        int warrantyMonths = sc.nextInt();
        LocalDate purchaseDate = LocalDate.of(year, month, day);
        LocalDate expiryDate = purchaseDate.plusYears(warrantyYears).plusMonths(warrantyMonths);
        System.out.println("\nPurchase Date: " + purchaseDate);
        System.out.println("Warranty Expiry Date: " + expiryDate);
    }
}
