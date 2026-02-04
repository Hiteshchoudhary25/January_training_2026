package Package1;

import java.util.Scanner;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;



public class TC_FileWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Text");
		String text= sc.nextLine();
		FileWriter fw= new FileWriter("C:\\Users\\Dipansu\\Downloads\\abcc.txt");
		fw.write(text);
		fw.close();
		
		
	}

}
