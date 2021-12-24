package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePageObjects;

public class DashboardPage extends BasePageObjects {
	
private static final By byWelcome = By.xpath("//a[@id='welcome']");
	
	public static WebElement getWelcomeMessage(WebDriver driver)
	{
		waitForClickable(driver,byWelcome,40);
		return driver.findElement(byWelcome);
	}

}
