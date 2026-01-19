package pac7;

import java.io.FileReader;
import java.io.FileWriter;

public class Lab_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader rd = new FileReader("input.txt");
		FileWriter wt = new FileWriter("input.txt");
		
		StringBuilder sb = new StringBuilder();
		int ch;
		while((ch = rd.read()) != -1) {
			sb.append((char) ch);
		}
		rd.close();
		sb.reverse();
		wt.write(sb.toString());
		wt.close();
		
		System.out.println("File Content reversed sucessfully...");

	}

}
