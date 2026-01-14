package pac3;

//import java.util.Scanner;

public class Person {
	String firstName;
	String lastName;
    char Gender;
    String mobileNumber;
    
    public Person(String fn , String ln , char g,String num) {
    	this.firstName = fn;
    	this.lastName = ln;
    	this.Gender = g;
    	this.mobileNumber = num;
    }
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		this.Gender = gender;
	}
	public void setNumber(String number) {
		this.mobileNumber = number;
	}
	public String getNumber() {
		return mobileNumber;
	}
}
