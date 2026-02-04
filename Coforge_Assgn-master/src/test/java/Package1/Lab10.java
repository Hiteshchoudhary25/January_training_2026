package Package1;

import java.util.Scanner;

public class Lab10 {

   
    public static boolean isPositiveString(String s) {
        if (s == null || s.length() <= 1) {
            return true; 
        }

        String t = s.toUpperCase();

        for (int i = 1; i < t.length(); i++) {
            char prev = t.charAt(i - 1);
            char curr = t.charAt(i);

            if (curr <= prev) {
                return false;
            }
        }
        return true;
    }

   
    public static boolean isPositiveStringLettersOnly(String s) {
        if (s == null || s.length() <= 1) return true;

        String t = s.toUpperCase();
        for (int i = 1; i < t.length(); i++) {
            char prev = t.charAt(i - 1);
            char curr = t.charAt(i);

            if (prev < 'A' || prev > 'Z' || curr < 'A' || curr > 'Z') {
                return false;
            }
            if (curr <= prev) {
                return false; 
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        boolean positive = isPositiveString(input);

        if (positive) {
            System.out.println("Positive String");
        } else {
            System.out.println("Not Positive");
        }

        sc.close();
    }
}