package SeleniumPac;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab5_2 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
 
        WebDriverManager.chromedriver().setup();;
		WebDriver dr = new ChromeDriver();
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
		String password = sc.nextLine();
		dr.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(password);
		dr.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys(password);
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
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
		if (password.length()>=4 && password.length()<=20 ){
			System.out.println("valid password");
		}
		else {
			String passworderror = dr.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")).getText();
			System.out.println(passworderror);
		}
		String confirm = dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a"	)).getText();
		System.out.println(confirm);
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[1]/a")).click();
 
}
}
