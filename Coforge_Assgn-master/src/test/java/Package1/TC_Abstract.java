package Package1;


abstract class shape{
	abstract void draw();
}

class rectangle extends shape{
	void draw() {
		System.out.println("This is Rectangle class");
	}
}
public class TC_Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   rectangle rc= new rectangle();
   rc.draw();
	}

}
