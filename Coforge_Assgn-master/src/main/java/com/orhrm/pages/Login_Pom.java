package com.orhrm.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class Login_Pom {
	WebDriver driver;
	By uesrname=By.name("username");
	By password=By.name("password");
	By submitbutton=By.xpath("//button[@type='submit']");
	By dashboard=By.xpath("//h6[text()='Dashboard']");
	public Login_Pom(WebDriver driver2) {
		this.driver=driver2;
		// TODO Auto-generated constructor stub
	}
 
	public void enterusername(String uname)
	{
		driver.findElement(uesrname).sendKeys(uname);
	}
	public void enterpassword(String pword)
	{
		driver.findElement(password).sendKeys(pword);
	}
 
	public void clickonsubmit()
	{
		driver.findElement(submitbutton).click();
	}
	public boolean dashboardisplayed()
	{
		return driver.findElement(dashboard).isDisplayed();
	}
 
}
