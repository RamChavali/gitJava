package testcases;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import objectsrepo.AccountPreLoginPage;
import objectsrepo.AddCardFirstPage;
import objectsrepo.AddCardSecondPage;
import objectsrepo.ManageCardsPage;
import objectsrepo.OnboardingPage;
import objectsrepo.PropertiesReader;
import objectsrepo.StoresPage;

@SuppressWarnings("unused")
public class addCreditCard {
	
	File appDir = new File("src");
	File app = new File(appDir, "app-2.21.10-66.apk");
	DesiredCapabilities cap = new DesiredCapabilities();
	private WebDriver driver;

	/* PRECONDITION - at least 1 credit card on file - will refactor to handle scenario when no card is on file*/
	
	@Test
	public void skipOnboarding() throws Exception
	{
		// setup
		PropertiesReader properties = PropertiesReader.getInstance();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		WebDriverWait wait = new WebDriverWait(driver, 20);
	
		// page
		OnboardingPage onboardPage = new OnboardingPage(driver);
		StoresPage storesPage = new StoresPage(driver);
		AccountPreLoginPage accountPreLoginPage = new AccountPreLoginPage(driver);
		ManageCardsPage manageCardsPage = new ManageCardsPage(driver);
		AddCardFirstPage addCardFirstPage = new AddCardFirstPage(driver);
		AddCardSecondPage addCardSecondPage = new AddCardSecondPage(driver);
		
		// page actions
		onboardPage.gotItBtn().click();
		storesPage.navbar().click();
		storesPage.navMyAccount().click();
		accountPreLoginPage.signinLink().click();
		accountPreLoginPage.signinEmail().sendKeys(properties.get("emailStr"));
		accountPreLoginPage.signinPass().sendKeys(properties.get("passStr"));
		accountPreLoginPage.signinBtn().click();
		storesPage.navbar().click();
		storesPage.navManageCards().click();
		manageCardsPage.manageAddPaymentCardBtn().click();
		addCardFirstPage.addCardNum().sendKeys(properties.get("ccNumStr"));
		addCardFirstPage.addCardExp().sendKeys(properties.get("ccExpStr"));
		addCardFirstPage.addCardCCV().sendKeys(properties.get("ccCVVStr"));
		addCardFirstPage.addCardNextBtn().click();
		addCardFirstPage.addCardAddNewAddr().click();
		addCardSecondPage.addCardAddrFirst().sendKeys(properties.get("firstNameStr"));
		addCardSecondPage.addCardAddrLast().sendKeys(properties.get("lastNameStr"));
		addCardSecondPage.addCardAddrStreet().sendKeys(properties.get("addressStr"));
		driver.hideKeyboard();
		addCardSecondPage.addCardAddrCity().sendKeys(properties.get("cityStr"));
		driver.hideKeyboard();
		addCardSecondPage.addCardAddrZipcode().sendKeys(properties.get("zipStr"));
		driver.hideKeyboard();
		addCardSecondPage.addCardAddrAddBtn().click(); // 1st click to validate address
		addCardSecondPage.addCardAddrAddBtn().click(); // 2nd click to actually submit
		
		
		
	}

}
