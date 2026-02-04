package Package1;




import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
public class Lab_4_2 {
    public static void main(String[] args) {
        
        File file = new File("numbers.txt");
 
     
        System.out.println("Working directory: " + new File(".").getAbsolutePath());
 
        
        if (!file.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i <= 10; i++) {
                    if (i > 0) sb.append(",");
                    sb.append(i);
                }
                writer.write(sb.toString());
                System.out.println("Created " + file.getAbsolutePath() + " with values 0..10");
            } catch (IOException e) {
                System.err.println("Failed to create numbers.txt: " + e.getMessage());
                return;
            }
        }
 
      
        try (Scanner sc = new Scanner(file)) {
           
            sc.useDelimiter("[,\\s]+");
 
            System.out.print("Even numbers in the file: ");
            boolean printedAny = false;
 
            while (sc.hasNext()) {
                if (!sc.hasNextInt()) {
                   
                    sc.next();
                    continue;
                }
                int n = sc.nextInt();
                if (n % 2 == 0) {
                    System.out.print(n + " ");
                    printedAny = true;
                }
            }
 
            if (!printedAny) {
                System.out.print("(No even numbers found)");
            }
            System.out.println(); 
        } catch (IOException e) {
            System.err.println("Error reading numbers.txt: " + e.getMessage());
        }
    }
}
 