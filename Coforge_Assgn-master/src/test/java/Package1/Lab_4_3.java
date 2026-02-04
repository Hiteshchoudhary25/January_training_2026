package Package1;



import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Lab_4_3 {
 
 
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
 
        public static Employee fromCsv(String line) {
            String[] parts = splitCsv(line);
            if (parts.length != 4) {
                throw new IllegalArgumentException("Invalid CSV row: " + line);
            }
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String dept = parts[2];
            double salary = Double.parseDouble(parts[3]);
            return new Employee(id, name, dept, salary);
        }
 
        private static String escapeCsv(String s) {
            if (s == null) return "";
            boolean needQuotes = s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r");
            String escaped = s.replace("\"", "\"\"");
            return needQuotes ? "\"" + escaped + "\"" : escaped;
        }
 
       
        private static String[] splitCsv(String line) {
            List<String> out = new ArrayList<>();
            StringBuilder cur = new StringBuilder();
            boolean inQuotes = false;
 
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (inQuotes) {
                    if (c == '\"') {
                        if (i + 1 < line.length() && line.charAt(i + 1) == '\"') {
                            cur.append('\"'); // escaped quote
                            i++;
                        } else {
                            inQuotes = false;
                        }
                    } else {
                        cur.append(c);
                    }
                } else {
                    if (c == '\"') {
                        inQuotes = true;
                    } else if (c == ',') {
                        out.add(cur.toString());
                        cur.setLength(0);
                    } else {
                        cur.append(c);
                    }
                }
            }
            out.add(cur.toString());
            return out.toArray(new String[0]);
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
 
        public void writeToCsv(File file, List<Employee> employees) throws IOException {
            File parent = file.getAbsoluteFile().getParentFile();
            if (parent != null && !parent.exists()) parent.mkdirs();
 
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8))) {
 
                bw.write("id,name,department,salary");
                bw.newLine();
                for (Employee e : employees) {
                    bw.write(e.toCsv());
                    bw.newLine();
                }
            }
        }
 
        public List<Employee> readFromCsv(File file) throws IOException {
            List<Employee> result = new ArrayList<>();
            if (!file.exists()) {
                throw new FileNotFoundException("File not found: " + file.getAbsolutePath());
            }
 
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
 
                String line;
                boolean first = true;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;
 
                    // Skip header if present
                    if (first && line.toLowerCase().startsWith("id,")) {
                        first = false;
                        continue;
                    }
                    first = false;
 
                    try {
                        result.add(Employee.fromCsv(line));
                    } catch (IllegalArgumentException ex) {
                        System.err.println("Skipping malformed row: " + line + " (" + ex.getMessage() + ")");
                    }
                }
            }
            return result;
        }
    }
 
   
    public static void main(String[] args) {
        
        File file = new File("employees.csv");
        System.out.println("Working directory: " + new File(".").getAbsolutePath());
 
        List<Employee> employees = Arrays.asList(
                new Employee(101, "Dipansu", "Engineering", 8500.00),
                new Employee(102, "Rohan Sharma", "QA", 65000.50),
                new Employee(103, "Pooja Khurana", "Engineering", 98000.00),
                new Employee(104, "Siju Thampi", "R&D Group", 120000.75)
        );
 
        EmployeeService service = new EmployeeService();
 
        try {
           
            System.out.println("Writing employees to: " + file.getAbsolutePath());
            service.writeToCsv(file, employees);
            System.out.println("Write complete.\n");
 
        
            System.out.println("Reading employees back from file...");
            List<Employee> readBack = service.readFromCsv(file);
 
         
            System.out.println("=== Employees from file ===");
            for (Employee e : readBack) {
                System.out.println(e);
            }
 
            System.out.println("\n=== Analysis ===");
            System.out.println("Count written: " + employees.size() + ", count read: " + readBack.size());
            boolean idsMatch = readBack.stream().map(Employee::getId).sorted().toList()
                    .equals(employees.stream().map(Employee::getId).sorted().toList());
            System.out.println("IDs match: " + idsMatch);
            System.out.println("If counts/IDs match, file I/O worked as expected.");
 
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
