package SeleniumPac;
 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class Lab_11_2_PageFactory {
 
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
	
	@FindBy(name="search")
	WebElement searchMob;
	
	@FindBy(css=".input-group-btn > .btn")
	WebElement someBtn;
	
	@FindBy(id="input-search")
	WebElement inpBox;
	
	@FindBy(id="input-search")
	WebElement inpEntry;
	
	@FindBy(id="description")
	WebElement desc;
	
	@FindBy(id="button-search")
	WebElement searchBtn2;
	
	
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
	
	public void clickSearch() {
		searchMob.click();
	}
	
	public void clickInnerBox() {
		someBtn.click();
	}
	
	public void forCursor() {
		inpBox.click();
	}
	
	public void textEnter() {
		inpEntry.sendKeys("Mobile");
	}
	
	public void descrip() {
		desc.click();
	}
	
	public void ent() {
		searchBtn2.click();
	}
}