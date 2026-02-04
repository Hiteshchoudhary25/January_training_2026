package Package1;
import java.util.Scanner;
 
public class Lab2_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        try {
            System.out.print("Enter Employee ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());
 
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine().trim();
 
            System.out.print("Enter Salary: ");
            double salary = Double.parseDouble(sc.nextLine().trim());
 
            System.out.print("Enter Designation (Manager/Programmer/System Associate): ");
            String designation = sc.nextLine().trim();
 
            Employee emp = new Employee(id, name, salary, designation);
 
            EmployeeService service = new EmployeeServiceImpl();
            service.determineInsuranceScheme(emp);
 
            System.out.println("\nEmployee Details:");
            System.out.println(emp);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number entered. Please run again and enter numeric values for ID/Salary.");
        } finally {
            sc.close();
        }
    }
}
 

 
interface EmployeeService {
    void determineInsuranceScheme(Employee employee);
}
 
class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void determineInsuranceScheme(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
 
        double salary = employee.getSalary();
        String designation = employee.getDesignation();
 
        if (salary > 50000 && designation.equalsIgnoreCase("Manager")) {
            employee.setInsuranceScheme("Scheme A");
        } else if (salary >= 30000 && salary <= 50000
                && designation.equalsIgnoreCase("Programmer")) {
            employee.setInsuranceScheme("Scheme B");
        } else if (salary >= 20000 && salary < 30000
                && designation.equalsIgnoreCase("System Associate")) {
            employee.setInsuranceScheme("Scheme C");
        } else {
            employee.setInsuranceScheme("No Scheme");
        }
    }
}
 
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
 
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDesignation() { return designation; }
    public String getInsuranceScheme() { return insuranceScheme; }
 
    
    public void setInsuranceScheme(String insuranceScheme) {
        this.insuranceScheme = insuranceScheme;
    }
 
    @Override
    public String toString() {
        return "Employee ID: " + id +
               "\nName: " + name +
               "\nSalary: " + salary +
               "\nDesignation: " + designation +
               "\nInsurance Scheme: " + (insuranceScheme == null ? "Not Assigned" : insuranceScheme);
    }
}