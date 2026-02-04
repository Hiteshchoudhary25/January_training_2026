package Package1;


import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
 
class Person1 {
    public int calculateAge(LocalDate dob) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dob, today);
        return period.getYears();
    }
    public String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }
}
 
public class Lab15 {
	
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        Person1 person = new Person1();
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
 
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
 
        System.out.print("Enter Year of Birth (yyyy): ");
        int year = sc.nextInt();
 
        System.out.print("Enter Month of Birth (1-12): ");
        int month = sc.nextInt();
 
        System.out.print("Enter Day of Birth (1-31): ");
        int day = sc.nextInt();
        LocalDate dob = LocalDate.of(year, month, day);
        String fullName = person.getFullName(firstName, lastName);
        int age = person.calculateAge(dob);
        System.out.println("\n--- Person Details ---");
        System.out.println("Full Name: " + fullName);
        System.out.println("Age: " + age + " years");
    }
}
