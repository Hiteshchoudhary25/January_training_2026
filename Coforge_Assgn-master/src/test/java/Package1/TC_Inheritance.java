package Package1;

class Base{
	public void basemethod() {
		System.out.println("Base Method");
	}
}

class Derived extends Base{
	public void derivedmethod() {
		System.out.println("Derived Method");
	}
}

public class TC_Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Derived derived = new Derived();
     derived.basemethod();
	}

}
