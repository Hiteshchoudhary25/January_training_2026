package Package1;
 
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Lab_4_5 {
 
   
    static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;
 
        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
 
        public int getId() { return id; }
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }
 
    
        public String toCsv() {
            return escapeCsv(String.valueOf(id)) + "," +
                   escapeCsv(name) + "," +
                   escapeCsv(department) + "," +
                   escapeCsv(String.valueOf(salary));
        }
 
        private static String escapeCsv(String s) {
            if (s == null) return "";
            boolean needQuotes = s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r");
            String escaped = s.replace("\"", "\"\"");
            return needQuotes ? "\"" + escaped + "\"" : escaped;
        }
 
        @Override
        public String toString() {
            return "Employee{id=" + id +
                    ", name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary + '}';
        }
    }
 
 
    static class EmployeeService {
 
        
        public void appendToCsv(File file, List<Employee> employees) throws IOException {
            // Ensure parent folder exists
            File parent = file.getAbsoluteFile().getParentFile();
            if (parent != null && !parent.exists()) parent.mkdirs();
 
            boolean writeHeader = !file.exists() || file.length() == 0;
 
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8))) {
 
                if (writeHeader) {
                    bw.write("id,name,department,salary");
                    bw.newLine();
                }
                for (Employee e : employees) {
                    bw.write(e.toCsv());
                    bw.newLine();
                }
            }
        }
    }
 
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        File csv = new File("employees.csv");
 
        System.out.println("Working directory: " + new File(".").getAbsolutePath());
        System.out.println("=== Enter Employee Details (type 'n' to stop) ===");
 
        while (true) {
            System.out.print("Add a new employee? (y/n): ");
            String ans = in.nextLine().trim();
            if (ans.equalsIgnoreCase("n")) break;
            if (!ans.equalsIgnoreCase("y")) {
                System.out.println("Please answer y/n.");
                continue;
            }
 
            int id = readInt(in, "Enter ID (integer): ");
            String name = readNonEmpty(in, "Enter Name: ");
            String dept = readNonEmpty(in, "Enter Department: ");
            double salary = readDouble(in, "Enter Salary (number): ");
 
            employees.add(new Employee(id, name, dept, salary));
            System.out.println("Employee added.\n");
        }
 
        if (employees.isEmpty()) {
            System.out.println("No employees entered. Exiting.");
            return;
        }
 
      
        System.out.println("\n=== Employees Entered ===");
        for (Employee e : employees) {
            System.out.println(e);
        }
 
        
        EmployeeService service = new EmployeeService();
        try {
            service.appendToCsv(csv, employees);
            System.out.println("\nSaved " + employees.size() + " employee(s) to: " + csv.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }
 
   
    private static int readInt(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }
 
    private static double readDouble(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
 
    private static String readNonEmpty(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("This field cannot be empty.");
        }
    }
}