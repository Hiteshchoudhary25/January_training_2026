package pac5;

abstract class shape{
	abstract void draw();
}

class rectangle extends shape{
	void draw() {
		System.out.println("DRAWING RECTANGLE...");
	}
}

public class TC016_Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rectangle obj = new rectangle();
		obj.draw();
		

	}

}
