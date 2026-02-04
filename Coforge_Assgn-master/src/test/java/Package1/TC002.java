package Package1;

public class TC002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 20;
		
		if(num%2 ==0)
		{
			System.out.println("Even Number");
		}
		else {
			System.out.println("Odd Number");
		}
		
		int marks = 50;
		if(marks>=90) {
			System.out.println("Grade A");
		}
		else if(marks>=75) {
			System.out.println("Grade B");
		}
		else{
			System.out.println("Grade C");
		}
		
		int day = 3;
		switch(day) {
		case 1 : System.out.println("monday");
		break;
		case 2 : System.out.println("tuesday");
		break;
		case 3 : System.out.println("wednesday");
		break;
		}
		
		
		for(int i = 1 ; i<=5 ; i++) {
			System.out.println(i);
		}
		
		int j = 1;
		while(j<=5) {
			System.out.println(j);
			j++;
		}
		
		int k = 1;
		do{
			System.out.println(k);
			k++;
		}
		while(k<=5);
		
		
	}

}
