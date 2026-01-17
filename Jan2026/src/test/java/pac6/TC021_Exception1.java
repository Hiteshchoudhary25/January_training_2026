package pac6;

public class TC021_Exception1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int d = 0;
			int a = 50 / d;			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Wellcome to JAVA");

	}

}
