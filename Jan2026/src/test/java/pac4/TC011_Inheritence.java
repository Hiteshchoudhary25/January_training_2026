package pac4;

class Base{
	public void baseMethod() {
		System.out.println("Base Method...");
	}
}

class Derived extends Base{
	public void derivedMethod() {
		System.out.println("Derived Method...");
	}
}

public class TC011_Inheritence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Derived obj = new Derived();
		obj.baseMethod();
		obj.derivedMethod();

	}

}
