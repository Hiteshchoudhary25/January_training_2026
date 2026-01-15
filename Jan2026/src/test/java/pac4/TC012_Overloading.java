package pac4;

class car{
	int noofcylinders;
	int noofvales;
	int enginepower;
	boolean ispowersteeeing;
	
	car(){
		noofcylinders=3;
		noofvales = 4;
		enginepower = 46;
		ispowersteeeing = false;
	}
	car(boolean ispowersteering){
		this.ispowersteeeing = ispowersteering;
	}
	
	car(int noofcylinders , int noofvales , int enginepower){
		this.noofcylinders = noofcylinders;
		this.noofvales = noofvales;
		this.enginepower = enginepower;
		this.ispowersteeeing = true;
	}
	

}

public class TC012_Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		car obj = new car();
		System.out.println(obj.noofcylinders);
		
		car obj2 = new car();
		System.out.println("ispowerstearing :" + obj2.ispowersteeeing);
		
		car obj3 = new car();
		System.out.println("noofcyclinders :" + obj3.noofcylinders);
		System.out.println("noofcylinders :" + obj3.noofvales);
		System.out.println("noofcylinders:"+obj3.enginepower);
		System.out.println("ispoersteering:"+obj3.ispowersteeeing);

	}

}
