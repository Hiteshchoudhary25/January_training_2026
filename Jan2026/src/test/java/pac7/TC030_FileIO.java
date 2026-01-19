package pac7;

import java.io.FileInputStream;
import java.io.IOException;

public class TC030_FileIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        FileInputStream fis=new FileInputStream("C:\\samplefolder\sample.txt");
		
		int data;
		while((data=fis.read())!=-1)
		{
			System.out.println((char)data);
		}
		
		fis.close();

	}

}
