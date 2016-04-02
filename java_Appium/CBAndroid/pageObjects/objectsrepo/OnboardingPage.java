package objectsrepo;
import org.openqa.selenium.WebDriver;

public class OnboardingPage extends BasePage 
	{
		// SETUP
		PropertiesReader properties = PropertiesReader.getInstance();
		public OnboardingPage(WebDriver driver) throws Exception 
			{
				super(driver);
			}
		
		// METHODS
		public void clickGotItBtnAction() 
			{			
				clickById(wait, properties.get("gotItID"));
			}
		
		// TODO - swiping through onboarding pages	
	}
