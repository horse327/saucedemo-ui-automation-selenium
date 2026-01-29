package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SauceLoginPage;

public class LoginToNegativeTest  extends BaseTest {
	
	@Test
	public void shouldShowErrorForInvalidCredentials() {
		SauceLoginPage loginPage = new SauceLoginPage(driver);
		
		loginPage.login("invalid_user", "invalid_pass");
		
		Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"),
				"Expected error message for invalid credentials");
	}

	
	@Test
	public void shouldShowValidationForEmptyCredentials() {
		SauceLoginPage loginPage = new SauceLoginPage(driver);
		
		loginPage.login("", "");
		
		Assert.assertTrue(loginPage.isErrorDisplayed(),
				"Validation error should be displayed for empty credentials");
		
	}
}

	
