package Package1;

class parent{
	int x=10;
}

class child extends parent{
	int x=20;
	void display() {
		System.out.println(x);
		System.out.println(super.x);
	}
}
public class TC_SuoerKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      child c= new child();
      c.display();
	}

}
