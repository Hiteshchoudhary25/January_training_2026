package pac3;

public class lab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Person p = new Person();
//		p.setFirstName("Hitesh");
//		p.setLastName("Choudhary");
//		p.setGender('M');
//		sysout
//		System.out.println("Name : " + p.getFirstName());
//		System.out.println("Lastname : " + p.getLastName());
//		System.out.println("Gender is :" + p.getGender());
		
		Person obj = new Person("Hitesh" , "Patel" , 'M');
		System.out.println("Name : " + obj.getFirstName());
		System.out.println("Lastname : " + obj.getLastName());
		System.out.println("Gender is :" + obj.getGender());
			
		
		

	}

}
