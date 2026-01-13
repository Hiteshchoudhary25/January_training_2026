package pac1;
import java.util.*;
public class elseprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int age = sc.nextInt();
		if(age > 18 & age < 50) {
			System.out.println("You are eligible to vote and you're young NETA");
		}else {
			System.out.println("You can vote but you're not young NETA");
		}
		
		sc.close();

	}

}
