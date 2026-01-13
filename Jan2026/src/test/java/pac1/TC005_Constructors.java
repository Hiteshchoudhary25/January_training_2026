package pac1;
class Balance{
	String name;
	double bal;
	
	public Balance(String name , double bal) {
		this.name = name;
		this.bal = bal;
	}
	public void show() {
		if(bal > 0) {
			System.out.println("Name :" + name  +" & " + "bal -> " + bal);
		}
	}
}

public class TC005_Constructors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Balance obj = new Balance("Hitesh" , 600.00);
		obj.show();

	}

}
