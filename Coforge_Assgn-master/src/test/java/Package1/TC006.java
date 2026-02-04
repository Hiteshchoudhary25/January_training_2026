package Package1;

import java.util.Scanner;

public class TC006 {

    // Simple program for beginners: read an integer and say if it's positive, negative or zero
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        int n = sc.nextInt();
        sc.close();

        if (n > 0) {
            System.out.println(n + " is positive");
        } else if (n < 0) {
            System.out.println(n + " is negative");
        } else {
            System.out.println(n + " is zero");
        }
    }

}