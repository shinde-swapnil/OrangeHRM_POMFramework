package pages;

import org.openqa.selenium.WebDriver;

import base.BaseActions;
import base.BasePageObjects;

public class LoginAction extends BaseActions  
{
	private WebDriver driver;
	public LoginAction(WebDriver driver)
	{
		this.driver = driver;
	}
	public void perform(String username,String password){	
		BasePageObjects.waitForPageLoad();
		HrmLoginPage.getUserNameTextBox(driver).sendKeys(username);
		BasePageObjects.waitForPageLoad();
		HrmLoginPage.getPasswordTextBox(driver).sendKeys(password);
		BasePageObjects.waitForPageLoad();
		HrmLoginPage.getLoginButton(driver).click();		
	}
}
