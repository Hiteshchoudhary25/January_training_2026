package pac7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TC031_FileWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter text :");
		
		String text = sc.nextLine();
		FileWriter fw = new FileWriter("input.txt");
		fw.write(text);
		fw.close();

	}

}
