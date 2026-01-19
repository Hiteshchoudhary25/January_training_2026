package pac7;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class lab4_4 {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       ArrayList<String> products = new ArrayList<>();
       System.out.print("Enter number of products: ");
       int n = sc.nextInt();
       sc.nextLine();
       for (int i = 0; i < n; i++) {
           System.out.print("Enter product name " + (i + 1) + ": ");
           products.add(sc.nextLine());
       }
       Collections.sort(products);
       System.out.println("\nSorted Product Names:");
       for (String p : products) {
           System.out.println(p);
       }
       sc.close();
   }
}
