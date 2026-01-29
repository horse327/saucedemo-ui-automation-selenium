package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceLoginPage;
import utils.ConfigReader;

public class LoginPositiveTest extends BaseTest {
	
	@Test
	public void shouldLoginSuccessfully() {
		SauceLoginPage loginPage = new SauceLoginPage(driver);
		
		loginPage.login(ConfigReader.getProperty("sauce_username"),
						ConfigReader.getProperty("sauce_password"));
		
		Assert.assertTrue(loginPage.isInventoryPageVisible(),
				"User should be redirected to inventory page after succesful login");
	}
}