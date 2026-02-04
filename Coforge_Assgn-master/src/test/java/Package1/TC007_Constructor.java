package Package1;

class Balance{
	String name;
	double bal;
	
	public Balance(String n, double b) {
		
		name  = n;
		bal = b;
	}
	public void show() {
		if(bal>0) {
			System.out.println("Name :" + name + " $" + bal);
		}
	}
}

public class TC007_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Balance obj = new Balance("ravi", 60000.00);
		obj.show();
		
	}

}
