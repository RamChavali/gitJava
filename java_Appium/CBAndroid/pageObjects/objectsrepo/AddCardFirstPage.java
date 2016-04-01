package objectsrepo;
import java.io.File;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

@SuppressWarnings("unused")
public class AddCardFirstPage {

	// setup
	PropertiesReader properties = PropertiesReader.getInstance();
	private WebDriver driver;
	private FluentWait<WebDriver> wait;
	public AddCardFirstPage(WebDriver driver) throws Exception {
		this.driver=driver;
		WebDriverWait wait = new WebDriverWait(driver, 20);
	}
	
	// page elements 
	public WebElement addCardNum() {
		return driver.findElement(By.id(properties.get("addCardNumId")));
	}
	public WebElement addCardExp() {
		return driver.findElement(By.id(properties.get("addCardExpId")));
	}
	public WebElement addCardCCV() {
		return driver.findElement(By.id(properties.get("addCardCCVId")));
	}
	public WebElement addCardNextBtn() {
		return driver.findElement(By.id(properties.get("addCardNextBtnId")));
	}

	// select billing address elements 
	public WebElement addCardSelectExistingAddr() {
		return driver.findElement(By.id(properties.get("addCardSelectExistingAddrId")));
	}
	public WebElement addCardAddNewAddr() {
		return driver.findElement(By.id(properties.get("addCardAddNewAddrId")));
	}
	
	
	
	
}
