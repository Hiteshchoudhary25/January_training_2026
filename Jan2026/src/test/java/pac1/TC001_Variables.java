package pac1;

public class TC001_Variables {
	private static double width;
	private static double height;
	private static double depth;
	private static int boxid;
	
	public static  double volume() {
		double temp;
		temp = width * height * depth;
		return temp;
	}
	

	public static void main(String[] args) {
		
		System.out.println(volume());
		
	}

}
