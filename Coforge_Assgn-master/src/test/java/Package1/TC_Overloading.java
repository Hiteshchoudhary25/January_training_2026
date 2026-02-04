package Package1;

class car{
	int noofcylinder;
	int noofvalves;
	int enginepower;
	boolean ispoesteering;
	
	car(){
		noofcylinder=3;
		noofvalves=4;
		enginepower=46;
		ispoesteering=false;
		
	}
	car(boolean ispoersteering){
		this.ispoesteering= ispoersteering;
		
	}
	car(int noofcylinder, int noofvalves,int enginepower){
		this.noofcylinder=noofcylinder;
		this.noofvalves=noofvalves;
		this.enginepower= enginepower;
		this.ispoesteering=true;
		
	}
}


public class TC_Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     car obj1= new car();
     System.out.println(obj1.noofcylinder);
     car obj2= new car(true);
     System.out.println("ispoesteering:"+obj2.ispoesteering);
     car obj3= new car(90,78,4);
     System.out.println("noofvalves: "+obj3.noofvalves+"noofcylinder :"+obj3.noofcylinder+"eninepoweer: "+obj3.enginepower);
		
	}

}
