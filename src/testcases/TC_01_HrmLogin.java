package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseActions;
import pages.DashboardPage;
import pages.HrmLoginPage;
import pages.LoginAction;


public class TC_01_HrmLogin extends BaseActions {
	
	@Test
	public void sucessfullLoginActionTest(){
		LoginAction LoginAction = new LoginAction(driver);
		LoginAction.perform("Admin", "admin123");
		Assert.assertTrue(DashboardPage.getWelcomeMessage(driver).getText().contains("Welcome"));
	}

	@Test
	public void rightUserNameWrongPasswordLoginActionTest(){
		LoginAction LoginAction = new LoginAction(driver);
		LoginAction.perform("Admin", "qa123");		
		Assert.assertTrue(HrmLoginPage.getErrorMessage(driver).getText().contains("Invalid credentials"));
	}
	@Test
	public void rightUserNameBlankPasswordLoginActionTest(){
		LoginAction LoginAction = new LoginAction(driver);
		LoginAction.perform("Admin", "");
		Assert.assertTrue(HrmLoginPage.getErrorMessage(driver).getText().contains("Password cannot be empty"));
	}
	@Test
	public void wrongUserNameRightPasswordLoginActionTest(){
		LoginAction LoginAction = new LoginAction(driver);
		LoginAction.perform("123qa", "admin123");
		Assert.assertTrue(HrmLoginPage.getErrorMessage(driver).getText().contains("Invalid credentials"));
	}
	@Test
	public void wrongUserNameWrongPasswordLoginActionTest(){
		LoginAction LoginAction = new LoginAction(driver);
		LoginAction.perform("qa", "admin");
		Assert.assertTrue(HrmLoginPage.getErrorMessage(driver).getText().contains("Invalid credentials"));
	}
	@Test
	public void wrongUserNameBlankPasswordLoginActionTest(){
		LoginAction LoginAction = new LoginAction(driver);
		LoginAction.perform("qa", "");
		Assert.assertTrue(HrmLoginPage.getErrorMessage(driver).getText().contains("Password cannot be empty"));
	}
	
	@Test
	public void blankUserNameRightPasswordLoginActionTest(){
		LoginAction LoginAction = new LoginAction(driver);
		LoginAction.perform("", "admin123");
		Assert.assertTrue(HrmLoginPage.getErrorMessage(driver).getText().contains("Username cannot be empty"));
	}
	@Test
	public void blankUserNameWrongPasswordLoginActionTest(){
		LoginAction LoginAction = new LoginAction(driver);
		LoginAction.perform("", "adm");
		Assert.assertTrue(HrmLoginPage.getErrorMessage(driver).getText().contains("Username cannot be empty"));
	}
	@Test
	public void blankUserNameBlankPasswordLoginActionTest(){
		LoginAction LoginAction = new LoginAction(driver);
		LoginAction.perform("", "");
		Assert.assertTrue(HrmLoginPage.getErrorMessage(driver).getText().contains("Username cannot be empty"));
	}

}
