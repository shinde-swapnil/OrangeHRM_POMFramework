package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePageObjects;

public class HrmLoginPage extends BasePageObjects {
	
	
	private static final By byTxtUserName = By.id("txtUsername");
	private static final By byTxtPassword = By.id("txtPassword");
	private static final By byBtnLogin = By.id("btnLogin");
	private static final By bySpanMessage = By.id("spanMessage");
	
	
	public static WebElement getUserNameTextBox(WebDriver driver){
		waitForElementVisible(driver,byTxtUserName,15);
		return driver.findElement(byTxtUserName);
	}
	public static WebElement getPasswordTextBox(WebDriver driver){
		return driver.findElement(byTxtPassword);
	}
	public static WebElement getLoginButton(WebDriver driver){
		return driver.findElement(byBtnLogin);
	}	
	public static WebElement getErrorMessage(WebDriver driver){
		return driver.findElement(bySpanMessage);
	}

}
