package SeleniumPac;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class Login_PageFactory {
	WebDriver driver;
//	By username=By.name("username");
	@FindBy(name="username")
	WebElement username;
	
//	By password=By.name("password");
	@FindBy(name="password")
	WebElement password;
	
//	By submitbutton=By.xpath("//button[@type='submit']");
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbutton;
	
//	By dashboard=By.xpath("//h6[text()='Dashboard']");
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement dashboard;
	
	
	public Login_PageFactory(WebDriver driver2) {
		
		this.driver=driver2;
		
		// TODO Auto-generated constructor stub
	}
 
	public void enterusername(String uname)
	{
		username.sendKeys(uname);
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

 