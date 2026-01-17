package pac5;

import java.util.Scanner;

//Employee class
class Employee {

 private int id;
 private String name;
 private double salary;
 private String designation;
 private String insuranceScheme;

 public Employee(int id, String name, double salary, String designation) {
     this.id = id;
     this.name = name;
     this.salary = salary;
     this.designation = designation;
 }

 public int getId() {
     return id;
 }

 public String getName() {
     return name;
 }

 public double getSalary() {
     return salary;
 }

 public String getDesignation() {
     return designation;
 }

 public String getInsuranceScheme() {
     return insuranceScheme;
 }

 public void setInsuranceScheme(String insuranceScheme) {
     this.insuranceScheme = insuranceScheme;
 }
}

//Service interface
interface EmployeeService {
 void findInsuranceScheme(Employee emp);
}

//Service implementation
class EmployeeServiceImpl implements EmployeeService {

 @Override
 public void findInsuranceScheme(Employee emp) {

     double salary = emp.getSalary();
     String designation = emp.getDesignation();

     if (salary > 50000 && designation.equalsIgnoreCase("Manager")) {
         emp.setInsuranceScheme("Scheme A");
     } else if (salary > 30000) {
         emp.setInsuranceScheme("Scheme B");
     } else if (salary > 20000) {
         emp.setInsuranceScheme("Scheme C");
     } else {
         emp.setInsuranceScheme("No Scheme");
     }
 }
}

//Main class
public class lab2_3 {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     System.out.print("Enter Employee ID: ");
     int id = sc.nextInt();
     sc.nextLine();

     System.out.print("Enter Employee Name: ");
     String name = sc.nextLine();

     System.out.print("Enter Salary: ");
     double salary = sc.nextDouble();
     sc.nextLine();

     System.out.print("Enter Designation: ");
     String designation = sc.nextLine();

     Employee emp = new Employee(id, name, salary, designation);

     EmployeeService service = new EmployeeServiceImpl();
     service.findInsuranceScheme(emp);

     System.out.println("\nEmployee Details");
     System.out.println("ID: " + emp.getId());
     System.out.println("Name: " + emp.getName());
     System.out.println("Salary: " + emp.getSalary());
     System.out.println("Designation: " + emp.getDesignation());
     System.out.println("Insurance Scheme: " + emp.getInsuranceScheme());

     sc.close();
 }
}

