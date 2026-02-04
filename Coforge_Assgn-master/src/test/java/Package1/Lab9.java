
package Package1;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        System.out.println("Choose an operation:");
        System.out.println("1. Add string to itself");
        System.out.println("2. Replace odd positions with #");
        System.out.println("3. Remove duplicate characters");
        System.out.println("4. Change odd characters to uppercase");

        int choice = sc.nextInt();

        String result = performOperation(input, choice);
        System.out.println("Result: " + result);

        sc.close();
    }

  
    public static String performOperation(String str, int choice) {

        switch (choice) {

            case 1: 
                return str + str;

            case 2: 
                StringBuilder sb1 = new StringBuilder(str);
                for (int i = 1; i < sb1.length(); i += 2) { 
                    sb1.setCharAt(i, '#');
                }
                return sb1.toString();

            case 3: 
                Set<Character> set = new LinkedHashSet<>();
                for (char ch : str.toCharArray()) {
                    set.add(ch);
                }
                StringBuilder sb2 = new StringBuilder();
                for (char c : set) {
                    sb2.append(c);
                }
                return sb2.toString();

            case 4: 
                StringBuilder sb3 = new StringBuilder(str);
                for (int i = 1; i < sb3.length(); i += 2) {
                    sb3.setCharAt(i, Character.toUpperCase(sb3.charAt(i)));
                }
                return sb3.toString();

            default:
                return "Invalid choice!";
        }
    }
}

