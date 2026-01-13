package pac1;

public class TC002_Controlstatements {
	public int number = 69;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 20;
		
		if(num % 2 == 0) {
			System.out.println("Even Number");
		}else {
			System.out.println("Odd Number");
		}
		
		
		int marks = 50;
		if(marks >= 90) {
			System.out.println("Grade A");
		}else if(marks >= 75) {
			System.out.println("Grade B");
		}else {
			System.out.println("Grade C");
		}
		
		int days = 3;
		switch(days) {
		case 1 : 
			System.out.println("MonDAY");
		break;
		case 2 : 
			System.out.println("Tuesday");
			break;
		case 3 :
			System.out.println("Wed");
		}
		
		for(int i = 0; i <  5; i++) {
			System.out.println(i + ". Hitesh Choudhary " );
		}
		
		int j = 1;
		while(j <= 2) {
			System.out.println("While loop...");
			j++;
		}
		
		int k=1;
		do
		{
			System.out.println(k);
			k++;
			
		}while(k<=5);
		
		}
		

}

