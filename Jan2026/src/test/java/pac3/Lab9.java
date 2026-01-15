package pac3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab9 {
	public static String stringOper(String str , int choice) {
		switch(choice) {
		case 1 : 
			return str + str;
		case 2 :
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < str.length(); i++) {
				if(i % 2 != 0) {
					sb.append("#");
				}else {
					sb.append(str.charAt(i));
				}
			}
			return sb.toString();
		case 3 :
			StringBuilder sb2 = new StringBuilder();
			Set<Character> seen = new HashSet<>();
			for(char ch : str.toCharArray()) {
				if(!seen.contains(ch)) {
					sb2.append(ch);
					seen.add(ch);
				}
			}
			return sb2.toString();
		case 4:
			StringBuilder sb3 = new StringBuilder();
			for(int i = 0; i < str.length(); i++) {
				if(i % 2 != 0) {
					sb3.append(Character.toUpperCase(str.charAt(i)));
				}else {
					sb3.append(str.charAt(i));
				}
			}
			return sb3.toString();
		}
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose an operation:");
        System.out.println("1. Add the String to itself");
        System.out.println("2. Replace odd positions with #");
        System.out.println("3. Remove duplicate characters");
        System.out.println("4. Change odd characters to upper case");
        int choice = sc.nextInt();
        
        String res = stringOper(input , choice);
        System.out.println(res);

	}

}
