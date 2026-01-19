package pac7;

import java.util.*;
class Employee {
   int empId;
   String name;
   double salary;
   String insuranceScheme;
   Employee(int empId, String name, double salary, String insuranceScheme) {
       this.empId = empId;
       this.name = name;
       this.salary = salary;
       this.insuranceScheme = insuranceScheme;
   }
   void display() {
       System.out.println(empId + " | " + name + " | " + salary + " | " + insuranceScheme);
   }
}
public class lab4_5 {
   static HashMap<Integer, Employee> empMap = new HashMap<>();
   static Scanner sc = new Scanner(System.in);
   public static void main(String[] args) {
       int choice;
       do {
           System.out.println("\n1. Add Employee");
           System.out.println("2. Display Employees by Insurance Scheme");
           System.out.println("3. Delete Employee");
           System.out.println("4. Display All Employees");
           System.out.println("5. Exit");
           System.out.print("Enter choice: ");
           choice = sc.nextInt();
           switch (choice) {
               case 1:
                   addEmployee();
                   break;
               case 2:
                   displayByInsurance();
                   break;
               case 3:
                   deleteEmployee();
                   break;
               case 4:
                   displayAll();
                   break;
               case 5:
                   System.out.println("Exiting...");
                   break;
               default:
                   System.out.println("Invalid choice");
           }
       } while (choice != 5);
   }
  
   static void addEmployee() {
       System.out.print("Enter Employee ID: ");
       int id = sc.nextInt();
       sc.nextLine();
       System.out.print("Enter Name: ");
       String name = sc.nextLine();
       System.out.print("Enter Salary: ");
       double salary = sc.nextDouble();
       sc.nextLine();
       System.out.print("Enter Insurance Scheme: ");
       String scheme = sc.nextLine();
       empMap.put(id, new Employee(id, name, salary, scheme));
       System.out.println("Employee added successfully");
   }
  
   static void displayByInsurance() {
       sc.nextLine();
       System.out.print("Enter Insurance Scheme: ");
       String scheme = sc.nextLine();
       boolean found = false;
       for (Employee e : empMap.values()) {
           if (e.insuranceScheme.equalsIgnoreCase(scheme)) {
               e.display();
               found = true;
           }
       }
       if (!found) {
           System.out.println("No employee found with this insurance scheme");
       }
   }

   static void deleteEmployee() {
       System.out.print("Enter Employee ID to delete: ");
       int id = sc.nextInt();
       if (empMap.remove(id) != null) {
           System.out.println("Employee deleted successfully");
       } else {
           System.out.println("Employee not found");
       }
   }
   static void displayAll() {
       if (empMap.isEmpty()) {
           System.out.println("No employees available");
           return;
       }
       System.out.println("EmpID | Name | Salary | Insurance");
       for (Employee e : empMap.values()) {
           e.display();
       }
   }
}
