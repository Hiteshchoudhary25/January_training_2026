package pac1;

class Box{
	double width = 10;
	double height = 20;
	double depth = 10;
	
	double calVolume() {
		return width * height * depth;
	}
}

public class TC003_Classes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box box = new Box();
		System.out.println(box.calVolume());

	}

}
