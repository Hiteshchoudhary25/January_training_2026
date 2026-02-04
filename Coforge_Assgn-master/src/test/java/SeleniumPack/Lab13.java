package SeleniumPack;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;
import org.w3c.dom.*;
 
 
public class Lab13 {
 
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
 
   
    private static final String XML_FILE_NAME = "ObjectRepository.xml";
    private static final String XML_PATH = new File(System.getProperty("user.dir"), XML_FILE_NAME).getAbsolutePath();
 
    private Document xmlDoc;
 
    @BeforeClass
    public void setUp() {
        xmlDoc = loadXmlFromFile(XML_PATH);
 
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
 
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
 
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }
 
    private Document loadXmlFromFile(String absolutePath) {
        try {
            File f = new File(absolutePath);
            if (!f.exists()) {
                throw new RuntimeException("XML not found at: " + absolutePath);
            }
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(false);
            dbf.setIgnoringComments(true);
            dbf.setCoalescing(true);
            dbf.setIgnoringElementContentWhitespace(true);
 
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.parse(f);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load/parse XML at: " + absolutePath, e);
        }
    }
 
    private Element element(String key) {
        String[] parts = key.split("\\.");
        Element current = xmlDoc.getDocumentElement();
        for (String part : parts) {
            current = getFirstDirectChildByTagName(current, part);
            if (current == null) {
                throw new RuntimeException("No element for key='" + key + "', missing tag='" + part + "'");
            }
        }
        return current;
    }
 
    private Element getFirstDirectChildByTagName(Element parent, String tag) {
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node n = children.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE && ((Element) n).getTagName().equals(tag)) {
                return (Element) n;
            }
        }
        return null;
    }
 
    private By by(String key) {
        Element el = element(key);
        String locator = el.getAttribute("locator");
        if (locator == null || locator.isEmpty()) {
            throw new RuntimeException("Element for key '" + key + "' does not have a 'locator' attribute.");
        }
        String value = el.getTextContent().trim();
 
        switch (locator.toLowerCase()) {
            case "id":              return By.id(value);
            case "name":            return By.name(value);
            case "css":
            case "cssselector":     return By.cssSelector(value);
            case "xpath":           return By.xpath(value);
            case "linktext":        return By.linkText(value);
            case "partiallinktext": return By.partialLinkText(value);
            default:
                throw new RuntimeException("Unsupported locator type: '" + locator + "' for key: " + key);
        }
    }
 
    private String text(String key) {
        return element(key).getTextContent().trim();
    }
 
    @Test
    public void lab13_flow_xml_from_file() {
        driver.get(text("base.url"));
        Assert.assertTrue(
                wait.until(ExpectedConditions.titleContains(text("base.titleContains"))),
                "Title did not contain expected text."
        );
 
        WebElement desktops = wait.until(ExpectedConditions.visibilityOfElementLocated(by("desktops.menu")));
        actions.moveToElement(desktops).pause(Duration.ofMillis(500)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(by("desktops.showAll"))).click();
 
        wait.until(ExpectedConditions.elementToBeClickable(by("mac.link"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(by("mac.heading")));
 
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(by("sort.dropdown"))));
        select.selectByVisibleText(text("sort.visibleText"));
 
        WebElement add = wait.until(ExpectedConditions.elementToBeClickable(by("addToCart.first")));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'}); arguments[0].click();", add);
 
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(by("searchTop.box")));
        search.clear();
        search.sendKeys(text("searchAdvanced.term"));
        wait.until(ExpectedConditions.elementToBeClickable(by("searchTop.button"))).click();
 
        WebElement criteria = wait.until(ExpectedConditions.visibilityOfElementLocated(by("searchAdvanced.criteria")));
        criteria.clear();
 
        WebElement desc = wait.until(ExpectedConditions.elementToBeClickable(by("searchAdvanced.inDescription")));
        if (!desc.isSelected()) desc.click();
 
        wait.until(ExpectedConditions.elementToBeClickable(by("searchAdvanced.submit"))).click();
 
    }
 
    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}