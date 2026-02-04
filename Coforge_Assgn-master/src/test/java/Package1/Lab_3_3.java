package Package1;

import java.util.Scanner;
 
public class Lab_3_3 {
 
    static class Employee {
        private int id;
        private String name;
        private double salary;
 
        public Employee(int id, String name, double salary) throws EmployeeException {
            if (salary < 3000) {
                throw new EmployeeException("Salary must be at least 3000. Given: " + salary);
            }
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
 
        public void display() {
            System.out.println("\nEmployee Details");
            System.out.println("ID     : " + id);
            System.out.println("Name   : " + name);
            System.out.println("Salary : " + salary);
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        try {
            System.out.print("Enter Employee ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());
 
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine().trim();
 
            System.out.print("Enter Employee Salary: ");
            double salary = Double.parseDouble(sc.nextLine().trim());
 
            Employee emp = new Employee(id, name, salary);
            emp.display();
 
        } catch (EmployeeException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter numeric values for ID and Salary.");
        } finally {
            sc.close();
        }
    }
}
 
class EmployeeException extends Exception {
    public EmployeeException(String message) {
        super(message);
    }
}