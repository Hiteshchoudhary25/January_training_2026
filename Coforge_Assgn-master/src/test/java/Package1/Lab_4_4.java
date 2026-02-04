package Package1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
 
public class Lab_4_4 {
 
   
    public static void main(String[] args) {
        List<String> products = new ArrayList<>(
                Arrays.asList("Mouse", "keyboard", "Monitor", "USB Cable", "Adapter", "charger", "mouse")
        );
 
        
        Collections.sort(products);
 
        System.out.println("=== Sorted product names (basic, case-sensitive) ===");
        for (String name : products) {
            System.out.println(name);
        }
 
    }
 

    public static void enhanced() {
        List<String> products = new ArrayList<>(
                Arrays.asList("Mouse", "keyboard", "Monitor", "USB Cable", "Adapter", "charger", "mouse", "Keyboard")
        );
 
        
        LinkedHashSet<String> seenLower = new LinkedHashSet<>();
        List<String> deduped = new ArrayList<>();
        for (String p : products) {
            String key = p.toLowerCase();
            if (!seenLower.contains(key)) {
                seenLower.add(key);
                deduped.add(p);
            }
        }
 
     
        deduped.sort(String.CASE_INSENSITIVE_ORDER);
 
        System.out.println("=== Sorted product names (enhanced, case-insensitive, unique) ===");
        for (String name : deduped) {
            System.out.println(name);
        }
    }
}