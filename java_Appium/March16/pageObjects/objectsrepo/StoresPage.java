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
public class StoresPage {
	
	// setup
	PropertiesReader properties = PropertiesReader.getInstance();
	private WebDriver driver;
	private FluentWait<WebDriver> wait;
	public StoresPage(WebDriver driver) throws Exception {
		this.driver=driver;
		WebDriverWait wait = new WebDriverWait(driver, 20);
	}
	
	// navbar suboptions
	public WebElement navbar() {			
		return driver.findElement(By.className(properties.get("navBarClass")));
	}
	public WebElement navMyPickups() {
		return driver.findElement(By.name(properties.get("navMyPickupsName")));
	}
	public WebElement navStores() {
		return driver.findElement(By.name(properties.get("navStoresName")));
	}
	public WebElement navShareWithFriends() {
		return driver.findElement(By.name(properties.get("navShareWithFriendsName")));
	}
	public WebElement navManageCards() {
		return driver.findElement(By.name(properties.get("navManageCardsName")));
	}
	public WebElement navMyAccount() {
		return driver.findElement(By.name(properties.get("navMyAccountName")));
	}
	public WebElement navClaimPromotions() {
		return driver.findElement(By.name(properties.get("navClaimPromotionsName")));
	}
	public WebElement navHelpNFAQs() {
		return driver.findElement(By.name(properties.get("navHelpNFAQsName")));
	}
	
	// header - search/car/nearby/map
	public WebElement searchBar() {			
		return driver.findElement(By.id(properties.get("searchBarId")));
	}
	public WebElement cartIcon() {			
		return driver.findElement(By.id(properties.get("cartIconId")));
	}
	public WebElement nearbyLink() {			
		return driver.findElement(By.id(properties.get("nearbyLinkId")));
	}
	public WebElement mapLink() {			
		return driver.findElement(By.id(properties.get("mapLinkId")));
	}
	
	// retailer listing (store/mall) - frame/image/name/addr/status/distance/badge/view more 
	public WebElement retailerFrame() {			
		return driver.findElement(By.className(properties.get("retailerFrameClass")));
	}
	public WebElement retailerImage() {			
		return driver.findElement(By.id(properties.get("retailerImageId")));
	}
	public WebElement retailerName() {			
		return driver.findElement(By.id(properties.get("retailerNameId")));
	}
//	public WebElement retailerAddr() {			
//		return driver.findElement(By.id(properties.get("retailerAddrId")));
//	}
	public WebElement retailerStatus() {			
		return driver.findElement(By.id(properties.get("retailerStatusId")));
	}
	public WebElement retailerDistance() {			
		return driver.findElement(By.id(properties.get("retailerDistanceId")));
	}
	public WebElement retailerBadge() {			
		return driver.findElement(By.id(properties.get("retailerBadgeId")));
	}
	public WebElement retailerViewMore() {			
		return driver.findElement(By.id(properties.get("retailerViewMoreId")));
	}
	
	
	

}
