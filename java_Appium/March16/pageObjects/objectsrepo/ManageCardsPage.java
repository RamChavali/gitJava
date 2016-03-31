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
public class ManageCardsPage {

	// setup
	PropertiesReader properties = PropertiesReader.getInstance();
	private WebDriver driver;
	private FluentWait<WebDriver> wait;
	public ManageCardsPage(WebDriver driver) throws Exception {
		this.driver=driver;
		WebDriverWait wait = new WebDriverWait(driver, 20);
	}
	
	// page elements 
	public WebElement manageCardsIndividualFrame() {
		return driver.findElement(By.className(properties.get("manageCardsIndividualFrameClass")));
	}
	public WebElement managePaymentCardsLink() {
		return driver.findElement(By.name(properties.get("managePaymentCardsLinkName")));
	}
	public WebElement manageLoyaltyCardsLink() {
		return driver.findElement(By.name(properties.get("manageLoyaltyCardsLinkName")));
	}
	public WebElement manageAddPaymentCardBtn() {
		return driver.findElement(By.name(properties.get("manageAddPaymentCardBtnName")));
	}
	public WebElement manageCardLastFour() {
		return driver.findElement(By.id(properties.get("manageCardLastFourId")));
	}
	public WebElement manageCardRemoveX() {
		return driver.findElement(By.id(properties.get("manageCardRemoveXId")));
	}
	public WebElement manageAddLoyaltyCard() {
		return driver.findElement(By.name(properties.get("manageAddLoyaltyCardName")));
	}
	
	
	
}
