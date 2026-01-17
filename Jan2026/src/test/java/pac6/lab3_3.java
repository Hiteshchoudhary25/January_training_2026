package pac6;

import java.util.Scanner;
class EmployeeException extends Exception{
	EmployeeException(String msg){
		super(msg);
	}
}

public class lab3_3 {
	static void validateSalary(double salary) throws EmployeeException{
		if(salary < 3000) {
			throw new EmployeeException("Salary must be atleast above 3000");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Name");
			String name = sc.next();
			
			System.out.println("Enter the salary");
			double salary = sc.nextDouble();
			
			validateSalary(salary);
			System.out.println("Employee name :" + name + " and salary is :" + salary);
		}catch(EmployeeException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
