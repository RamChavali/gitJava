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
public class AccountPreLoginPage {

	// setup
	PropertiesReader properties = PropertiesReader.getInstance();
	private WebDriver driver;
	private FluentWait<WebDriver> wait;
	public AccountPreLoginPage(WebDriver driver) throws Exception {
		this.driver=driver;
		WebDriverWait wait = new WebDriverWait(driver, 20);
	}
	
	// sign up elements
	
	
	// sign in elements
	public WebElement signinLink() {
		return driver.findElement(By.id(properties.get("preloginAcctSigninLinkId")));
	}
	public WebElement signinEmail() {
		return driver.findElement(By.id(properties.get("preloginAcctEmailFieldId")));
	}
	public WebElement signinPass() {
		return driver.findElement(By.id(properties.get("preloginAcctPassFieldId")));
	}
	public WebElement signinBtn() {
		return driver.findElement(By.id(properties.get("preloginAcctSigninBtnId")));
	}
	public WebElement signinForgotPassLink() {
		return driver.findElement(By.id(properties.get("preloginAcctForgotPassLinkId")));
	}
	public WebElement signinForgotPassEmail() {
		return driver.findElement(By.id(properties.get("preloginAcctForgotPassEmailId")));
	}
	public WebElement forgotPassResetPassBtn() {
		return driver.findElement(By.id(properties.get("preloginAcctForgotPassResetBtnId")));
	}
	
	
	
}
