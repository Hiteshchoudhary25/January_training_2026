package pac4;

class animal{
	void sound() {
		System.out.println("Animal makes sound..");
	}
}
class cat extends animal{
	void sound() {
		System.out.println("cat makes sound...");
	}
}

public class TC014_overding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		animal a = new cat();
//		System.out.println("sound :" + a.sound());
		a.sound();

	}

}
