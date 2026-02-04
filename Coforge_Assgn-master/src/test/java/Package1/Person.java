package Package1;

public class Person {

	String Firtsname;
	String Lastname;
	char Gender;
	String phoneNumber;
	
	public  Person(String fn, String ln, char g,String ph) {
		this.Firtsname=fn;
		this.Lastname=ln;
		this.Gender=g;
		this.phoneNumber=ph;
	}
	public String getFirtsname() {
		return Firtsname;
	}
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setFirtsname(String firtsname) {
		Firtsname = firtsname;
	}
	public void setphoneNumbe(String Number) {
		phoneNumber = Number;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	
	
	
}
