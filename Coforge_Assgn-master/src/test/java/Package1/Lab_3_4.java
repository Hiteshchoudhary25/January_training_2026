package Package1;
import java.util.Arrays;
 
public class Lab_3_4 {
    public static void main(String[] args) {
 
        String[] products = { "Mobile", "Laptop", "Charger", "Keyboard", "Mouse" };
 
        Arrays.sort(products);
 
        System.out.println("Sorted Product List:");
        for (String product : products) {
            System.out.println(product);
        }
    }
}
