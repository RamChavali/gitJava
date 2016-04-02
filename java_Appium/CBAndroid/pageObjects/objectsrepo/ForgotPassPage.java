package objectsrepo;

import org.openqa.selenium.WebDriver;

public class ForgotPassPage extends BasePage 
	{
		// SETUP
		PropertiesReader properties = PropertiesReader.getInstance();
		public ForgotPassPage(WebDriver driver) throws Exception 
			{
				super(driver);
			}
		
		// METHODS
		public void navToForgotPassScreen() 
			{			
				clickByClassName(wait, properties.get("navBarClass"));
				clickByName(wait, properties.get("navMyAccountName"));
				clickById(wait, properties.get("preloginAcctSigninLinkId"));
				clickById(wait, properties.get("preloginAcctForgotPassLinkId"));
			}
		public void resetPassUsingValidEmailUser() 
			{			
				enterInputById(wait, properties.get("preloginAcctForgotPassEmailId"), properties.get("emailStr"));
				clickById(wait, properties.get("preloginAcctForgotPassResetBtnId"));
			}
		public void resetPassUsingValidEmailNonUser() 
			{			
				enterInputById(wait, properties.get("preloginAcctForgotPassEmailId"), properties.get("emailNonUserStr"));
				clickById(wait, properties.get("preloginAcctForgotPassResetBtnId"));
			}
		public void resetPassUsingNullEmail() 
			{			
				enterInputById(wait, properties.get("preloginAcctForgotPassEmailId"), "");
				clickById(wait, properties.get("preloginAcctForgotPassResetBtnId"));
			}
		public void resetPassUsingInvalidEmail() 
			{			
				enterInputById(wait, properties.get("preloginAcctForgotPassEmailId"), properties.get("emailWrongStr"));
				clickById(wait, properties.get("preloginAcctForgotPassResetBtnId"));
			}
		
		// TODO - add todo items here
	}
