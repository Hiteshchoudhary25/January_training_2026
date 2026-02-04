package Package1;


public class TC008_Static {
	static int Num1=3;
	static int Num2=2;
	static {
		System.out.println("Static block initialized");
		Num2= Num1*4;
	}
	static void myMethod(int Num3) {
		System.out.println("Number 3 :"+Num3);
		System.out.println("Number 2 :"+Num2);
		System.out.println("Number 1 :"+Num1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  myMethod(42);
	}

}
