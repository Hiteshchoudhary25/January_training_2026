package Package1;
 
public class Lab6 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Gender	gen= Gender.MALE;
Person obj = new Person("Dipanshu","Choudhary",'M',"8789787898");
System.out.println("Firstname is "+obj.getFirtsname());
System.out.println("Lastname is "+obj.getLastname());
System.out.println("Gender is "+obj.getGender());
	}

}
