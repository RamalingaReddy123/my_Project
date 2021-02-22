package suite.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import suite.base.TestBase;
import suite.page.LoginPage;
import suite.testdata.LoginTestData;

public class LoginTest extends TestBase{
	
	private LoginPage dp;
	
	/**
	 * create page url
	 * 
	 * @return home page page url
	 */
	private String getPageURL() {
		return getEnv();
	}

	@Test(description = "Verify that successfully login with valid credentials", groups = {"wip", "LoginTest" })
	public void dt_1()
	{
		 dp = new LoginPage(getDriver());
		 
		 dp.getLoginPage(getPageURL())
		     .enterUserName(LoginTestData.USERNAME)
		     .enterpassword(LoginTestData.PASSWORD)
		     .clickLoginBtn();
		 
		 String actual = dp.getValidationMessage();
		 
		 Assert.assertEquals(actual, LoginTestData.EXPECTED_VALIDATION_MESSAGE);
		 
	}
	
	/*
	 * @Test(description = "For verifying if login icon redirect to login page.",
	 * groups = {"demo", "home" })
	 * 
	 * public void home_1() {
	 * 
	 * ht = new HomePage(getDriver());
	 * 
	 * String actual = ht.getHomePage(getPageURL()) .clkLoginIcon()
	 * .getLoginPageTitle();
	 * 
	 * Assert.assertEquals(actual, HomeTestData.LOGIN_PAGE_TITLE);
	 * 
	 * }
	 */
}
