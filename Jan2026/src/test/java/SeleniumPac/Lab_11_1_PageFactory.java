package SeleniumPac;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class Lab_11_1_PageFactory {
 
	@FindBy(css=".fa-bars")
	WebElement faBars;
 
	@FindBy(linkText="Desktops")
	WebElement searchDesktops;
	
	@FindBy(linkText="Mac (1)")
	WebElement mac;
	
	@FindBy(id="input-sort")
	WebElement sort;
	
	@FindBy(xpath="//option[. = 'Name (Z - A)']")
	WebElement sortSelect;
	
	@FindBy(css="#input-sort > option:nth-child(3)")
	WebElement selectChild;
	
	@FindBy(css=".button-group .fa-shopping-cart")
	WebElement cart;
	
	
	public void faBar() {
		faBars.click();
	}
	
	public void clickDesktop() {
		searchDesktops.click();
	}
	
	public void clickMac() {
		mac.click();
	}
	
	public void clickSort() {
		sort.click();
	}
	
	public void clickSortSelect() {
		sortSelect.click();
	}
	
	public void clickChild() {
		selectChild.click();
	}
	
	public void clickCart() {
		cart.click();
	}
}