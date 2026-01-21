package SeleniumPac;


import java.util.*;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab5{
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
        WebDriverManager.firefoxdriver().setup();
		WebDriver dr = new FirefoxDriver();
		dr.get("https://tutorialsninja.com/demo/index.php?");
 
 
		dr.findElement(By.linkText("My Account")).click();
		dr.findElement(By.linkText("Register")).click();
		String firstname= sc.nextLine();
		dr.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys(firstname);
		String lastname = sc.nextLine();
		dr.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys(lastname);
		String email = sc.nextLine();
		dr.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email);
		String phone = sc.nextLine()	;
		dr.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys(phone);
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		dr.findElement(By.xpath("//input[@value='Continue']")).click();
 
 
		if (firstname.length()<32) {
			System.out.println("valid");
		}
 
		else {
			String msg = dr.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
			System.out.println("Error is : "+msg);
	}
 
		if (lastname.length()<32) {
			System.out.println("Valid");
		}
		else {
			String msg2= dr.findElement(By.xpath("//*[@id=\"input-lastname\"]")).getText();
		System.out.println("Error is: " +msg2);	
		}
 
		if (phone.length()>=3 && phone.length()<=32) {
			System.out.println("Valid");
		}
		else {
 
			String phonerror= dr.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).getText();
		    System.out.println("Error is: " + phonerror);	
		}
 
 
}
}