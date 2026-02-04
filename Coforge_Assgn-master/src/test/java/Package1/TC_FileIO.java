package Package1;


import java.io.FileInputStream;
import java.io.IOException;
 
public class TC_FileIO {
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\Dipansu\\Downloads\\abcc.txt");
		
		int data;
		while((data=fis.read())!=-1)
		{
			System.out.println((char)data);
		}
		
		fis.close();
		
 
	}
 
}
 