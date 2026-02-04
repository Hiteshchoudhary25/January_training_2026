package Package1;

public class TC_Exception {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
 
	try {	String str= null;
		str.equals("Hello");
		
	}
		
	catch(Exception e) {	System.out.println(e.getMessage());
	}
	System.out.println("Welcome to Java");
	Thread.sleep(2000);
	
	}
	

}
