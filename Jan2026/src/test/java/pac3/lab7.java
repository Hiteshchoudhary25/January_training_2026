
package pac3;

import java.util.Scanner;

public class lab7 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first name: ");
            String fn = sc.nextLine();

            System.out.print("Enter last name: ");
            String ln = sc.nextLine();

            System.out.print("Enter gender (M/F): ");
            char g = sc.nextLine().trim().charAt(0);

            System.out.print("Enter mobile number: ");
            String mobile = sc.nextLine(); 

            Person obj = new Person(fn, ln, g, mobile);

            System.out.println("Name     : " + obj.getFirstName());
            System.out.println("Lastname : " + obj.getLastName());
            System.out.println("Gender   : " + obj.getGender());
            System.out.println("Mobile   : " + obj.getNumber());
        }
    }
}

