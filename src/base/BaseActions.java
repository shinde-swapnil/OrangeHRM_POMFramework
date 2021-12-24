package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseActions 
{
	protected static WebDriver driver;
	private String baseUrl = "https://opensource-demo.orangehrmlive.com/";
	
	@BeforeTest
	public void setUp() throws Exception 
	{
		String key = "webdriver.chrome.driver";
		String value = "D:\\Workspace\\OrangeHRM_POM\\browserDrivers\\chromedriver.exe";		
		System.setProperty(key, value);		
		driver = new ChromeDriver();			
		BasePageObjects.postUrl(driver, baseUrl);				
		driver.manage().window().maximize();
		BasePageObjects.wait(driver, 30);
	}
	
	
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

}
