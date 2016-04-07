package objectsrepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testPage_iOS extends BasePage 
	{
		// ########################################################################## [-BASIC SETUP-]
		PropertiesReader properties = PropertiesReader.getInstance();
		public testPage_iOS(WebDriver driver) throws Exception 
			{
				super(driver);
			}
		
		// ########################################################################## [-NAV TO STORES-]
		/* combined - steps 1 to 4 - navigates to the Stores Page */
		public void navToStoresPage() throws InterruptedException 
			{		
				this.clickXToSkipOnboarding();
				this.clickOKToEnableLocationInApp();
				this.clickOKToEnableLocationInDevice();
				this.assertArrivalOnStoresPage();
			}
		/* step 1 - click 'X' to skip onboarding flow */
		public void clickXToSkipOnboarding() 
			{
				//add
			}
		/* step 2 - click 'OK' to enable location in app level */
		public void clickOKToEnableLocationInApp() 
			{
				//add
			}
		/* step 3 - click 'Allow' to enable location in device level */
		public void clickOKToEnableLocationInDevice() 
			{
				//add
			}
		/* step 4 - assert user arrives on Stores Page */
		public void assertArrivalOnStoresPage() 
			{
				//add
			}
		// ########################################################################## [-STAGING-]
		/* staging method to test funtion before adding into actual steps */
		public void getCurrentPageSource() 
			{
				System.out.println("\n\n\n------------------------------------------------------------\n\n\n");
				System.out.println(driver.getPageSource());
				System.out.println("\n\n\n------------------------------------------------------------\n\n\n");
			}
		// ########################################################################## [-ADD CARD-]
		/* step 1 - click 'My Account' link from navigation bar menu */
		public void navToMyAccountScreen() throws InterruptedException 
			{
				clickByName(wait, "ListIcon");
				clickByName(wait, "My Account");
				clickByName(wait, "Sign In.");
				clickByValue(wait, "Email");
				
				
				
				//------------------------------->> pageSource
				this.getCurrentPageSource();
			}


		
		
		
			
		
		
	}
