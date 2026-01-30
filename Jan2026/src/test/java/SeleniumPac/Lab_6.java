package SeleniumPac;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab_6 {
 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
 
		WebDriverManager.edgedriver().setup();
		WebDriver dr = new EdgeDriver();
		String username="Mayankgupta123@gmail.com";
		String Password = "12345";
		dr.get("https://tutorialsninja.com/demo/index.php?");
		dr.findElement(By.linkText("My Account")).click();
		dr.findElement(By.linkText("Login")).click();

		dr.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(username);
		dr.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(Password);
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(1000);
		dr.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click();//component
		dr.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a")).click();//monitor
		dr.findElement(By.xpath("//*[@id=\"input-limit\"]")).click();//20option
		dr.findElement(By.xpath("//*[@id=\"input-limit\"]/option[2]")).click();//25option
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();//addtocart
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dr.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[1]/ul[2]/li[2]/a")).click();//specification
		 String text = dr.findElement(By.xpath("//*[@id=\"tab-specification\"]/table/thead/tr/td")).getText();	//
		System.out.println(text);
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")).click(); // whishlist
		String confirm = dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")).getText();
		System.out.println(confirm);
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dr.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("MOBILE");// searchtext box
		dr.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();//enter
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dr.findElement(By.xpath("//*[@id=\"description\"]")).click();//click checkbox
		dr.findElement(By.xpath("//*[@id=\"button-search\"]")).click();//search
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")).click();//htc mobile
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dr.findElement(By.xpath("//*[@id=\"input-quantity\"]")).clear();//quantity remove
		dr.findElement(By.xpath("//*[@id=\"input-quantity\"]")).sendKeys("3"); // quantity add
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dr.findElement(By.id("button-cart")).click();//add to cart
		String cnf2= dr.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText();//successmsg
		System.out.println(cnf2);
		dr.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();//viewcart
		dr.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")).click();//
		String mob = dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[2]/a")).getText();
		System.out.println(mob);

		dr.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();//checkout
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();//dropdown account
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();//logout
		String logout = dr.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		System.out.println(logout);
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();

 
		
		}
 
}
