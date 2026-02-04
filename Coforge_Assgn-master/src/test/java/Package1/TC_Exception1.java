package Package1;

public class TC_Exception1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		try {
			int d=0;
			int a=50/d;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finally Block");
		}
		System.out.println("Welcome to java");
		
	}

}
