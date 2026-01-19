package pac7;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab4_2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("numbers.txt"));
		sc.useDelimiter(",");
		
		System.out.println("Even Numbers : ");
		while(sc.hasNext()) {
			int num = sc.nextInt();
			if(num % 2 == 0) {
				System.out.println(num + " ");
			}
		}
		sc.close();

	}

}
