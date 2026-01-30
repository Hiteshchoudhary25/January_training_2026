package SeleniumPac;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class Lab_11_POM {
	WebDriver driver;
	
	By faBars = By.cssSelector(".fa-bars");
	
	By searchDesktop = By.linkText("Desktops");
	By mac = By.linkText("Mac (1)");
	
	By sort = By.id("input-sort");
	By sortSelect = By.xpath("//option[. = 'Name (Z - A)']");
	By selectChild = By.cssSelector("#input-sort > option:nth-child(3)");
	
	By cart = By.cssSelector(".button-group .fa-shopping-cart");
	
	
	public Lab_11_POM(WebDriver driver2) {
		this.driver = driver2;
	}
	
	public void faBar() {
		driver.findElement(faBars).click();
	}
	
	public void clickDesktop() {
		driver.findElement(searchDesktop).click();
	}
	
	public void clickMac() {
		driver.findElement(mac).click();
	}
	
	public void clickSort() {
		driver.findElement(sort).click();
	}
	
	public void clickSortSelect() {
		driver.findElement(sortSelect).click();
	}
	
	public void clickChild() {
		driver.findElement(selectChild).click();
	}
	
	public void clickCart() {
		driver.findElement(cart).click();
	}
}