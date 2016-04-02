package objectsrepo;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage 
	{
		// SETUP
		PropertiesReader properties = PropertiesReader.getInstance();
		public LoginPage(WebDriver driver) throws Exception 
			{
				super(driver);
			}
		
		// METHODS
		public void navToSigninScreen() 
			{			
				clickByClassName(wait, properties.get("navBarClass"));
				clickByName(wait, properties.get("navMyAccountName"));
				clickById(wait, properties.get("preloginAcctSigninLinkId"));
			}
		public void signinUsingValidCredentials() 
			{			
				enterInputById(wait, properties.get("preloginAcctEmailFieldId"), properties.get("emailStr"));
				enterInputById(wait, properties.get("preloginAcctPassFieldId"), properties.get("passStr"));
				clickById(wait, properties.get("preloginAcctSigninBtnId"));
				readTextById(wait, properties.get("postLoginAcctNameFieldId"));
				readTextById(wait, properties.get("postLoginAcctEmailFieldId"));
				readTextById(wait, properties.get("postLoginAcctPhoneFieldId"));
			}
		public void signinUsingInvalidEmail() 
			{			
				enterInputById(wait, properties.get("preloginAcctEmailFieldId"), properties.get("emailWrongStr")); 
				enterInputById(wait, properties.get("preloginAcctPassFieldId"), properties.get("passStr"));
				clickById(wait, properties.get("preloginAcctSigninBtnId"));
			}
		public void signinUsingInvalidPass() 
			{			
				enterInputById(wait, properties.get("preloginAcctEmailFieldId"), properties.get("emailStr")); 
				enterInputById(wait, properties.get("preloginAcctPassFieldId"), properties.get("passWrongStr"));
				clickById(wait, properties.get("preloginAcctSigninBtnId"));
			}
		public void signinUsingInvalidBoth() 
			{			
				enterInputById(wait, properties.get("preloginAcctEmailFieldId"), properties.get("emailWrongStr")); 
				enterInputById(wait, properties.get("preloginAcctPassFieldId"), properties.get("passWrongStr"));
				clickById(wait, properties.get("preloginAcctSigninBtnId"));
			}
		public void signinWithNullEmail() 
			{			
				enterInputById(wait, properties.get("preloginAcctEmailFieldId"), properties.get("")); 
				enterInputById(wait, properties.get("preloginAcctPassFieldId"), properties.get("passStr"));
				clickById(wait, properties.get("preloginAcctSigninBtnId"));
			}
		public void signinWithNullPass() 
			{			
				enterInputById(wait, properties.get("preloginAcctEmailFieldId"), properties.get("emailStr")); 
				enterInputById(wait, properties.get("preloginAcctPassFieldId"), properties.get(""));
				clickById(wait, properties.get("preloginAcctSigninBtnId"));
			}
		public void signinWithNullBoth() 
			{			
				enterInputById(wait, properties.get("preloginAcctEmailFieldId"), properties.get("")); 
				enterInputById(wait, properties.get("preloginAcctPassFieldId"), properties.get(""));
				clickById(wait, properties.get("preloginAcctSigninBtnId"));
			}
		
		
		
		
		
		
		
		
		
		
		// TODO - add todo items here
	}
