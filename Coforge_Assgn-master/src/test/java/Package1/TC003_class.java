package Package1;


class Box{
	double width = 10;
	double height = 20;
	double depth = 10;
	
	double calvolume() {
		return width * height * depth ;
	}
}

public class TC003_class {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Box obj = new Box();
		//obj.calvolume();
		System.out.println(obj.calvolume());
	}

}
