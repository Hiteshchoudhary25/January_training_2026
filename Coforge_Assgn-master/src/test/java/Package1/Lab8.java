package Package1;

public class Lab8 {
enum Gender{
	MALE,FEMALE
}
static class Person {

	String Firtsname;
	String Lastname;
	Gender gender;
	String phoneNumber;
	
	public  Person(String fn, String ln, Gender g,String ph) {
		this.Firtsname=fn;
		this.Lastname=ln;
		this.gender=g;
		this.phoneNumber=ph;
	}
	public void display(){
		System.out.println("GEnder is "+gender);
	}
	
	
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person obj = new Person("Dipanshu","Choudhary",Gender.MALE,"9015056274");
		obj.display();

	}

}
