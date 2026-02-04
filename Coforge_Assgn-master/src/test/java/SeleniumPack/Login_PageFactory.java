package SeleniumPack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class Login_PageFactory {
	WebDriver driver;
	//By uesrname=By.name("username");
	@FindBy(name="username")
	WebElement uesrname;
	//By password=By.name("password");
	@FindBy(name="password")
	WebElement password;
	//By submitbutton=By.xpath("//button[@type='submit']");
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbutton;
	//By dashboard=By.xpath("//h6[text()='Dashboard']");
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement dashboard;


 
	public void enterusername(String uname)
	{
		uesrname.sendKeys(uname);
	}
	public void enterpassword(String pword)
	{
		password.sendKeys(pword);
	}
 
	public void clickonsubmit()
	{
		submitbutton.click();
	}
	public boolean dashboardisplayed()
	{
		return dashboard.isDisplayed();
	}
 
}