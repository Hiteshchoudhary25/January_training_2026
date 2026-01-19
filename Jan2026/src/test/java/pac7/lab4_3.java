package pac7;



import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
   int id;
   String name;
   double salary;
   Employee(int id, String name, double salary) {
this.id = id;
       this.name = name;
       this.salary = salary;
   }
   public String toString() {
       return id + " " + name + " " + salary;
   }
}
public class lab4_3 {
   public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       // Write employee to file
       ObjectOutputStream out =
               new ObjectOutputStream(new FileOutputStream("employee.dat"));
       System.out.print("Enter Employee ID: ");
       int id = sc.nextInt();
       sc.nextLine();
       System.out.print("Enter Name: ");
       String name = sc.nextLine();
       System.out.print("Enter Salary: ");
       double salary = sc.nextDouble();
       Employee emp = new Employee(id, name, salary);
       out.writeObject(emp);
       out.close();
       // Read employee from file
       ObjectInputStream in =
               new ObjectInputStream(new FileInputStream("employee.dat"));
       Employee e = (Employee) in.readObject();
       in.close();
       System.out.println("\nEmployee read from file:");
       System.out.println(e);
       sc.close();
   }
}