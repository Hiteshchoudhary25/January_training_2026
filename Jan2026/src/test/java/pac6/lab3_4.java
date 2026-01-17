package pac6;

import java.util.Arrays;
import java.util.Scanner;

public class lab3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of Products :");
		int n = sc.nextInt();
		
		String[] products = new String[n];
		for(int i = 0; i < n; i++) {
			System.out.println("Enter product name :" + (i + 1) + " : ");
			products[i] = sc.nextLine();
		}
		Arrays.sort(products);
		System.out.println("sorted products");
		for(String str : products) {
			System.out.println(str);
		}
		sc.close();
	}

}
