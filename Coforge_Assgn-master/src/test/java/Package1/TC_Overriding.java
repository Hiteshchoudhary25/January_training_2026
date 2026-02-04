package Package1;

class animal{
	void sound() {
		System.out.println("Animal makes a sound");
	}
	
}
class cat extends animal{
	@Override
	void sound() {
		System.out.println("Cat sounds meow meow");
	}
}
public class TC_Overriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  animal an= new animal();
  an.sound();
  animal c= new cat();
  c.sound();
  
	}

}
