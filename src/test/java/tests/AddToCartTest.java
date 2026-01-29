package tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import base.BaseTest;
import pages.SauceInventoryPage;
import pages.SauceLoginPage;
import utils.ConfigReader;

public class AddToCartTest extends BaseTest{
	
	@Test
	public void shouldAddMultipleProductsToCart() {
		SauceLoginPage loginPage = new SauceLoginPage(driver);
		SauceInventoryPage inventoryPage = new SauceInventoryPage(driver);
		
		// Precondition: user logged in
		loginPage.login(ConfigReader.getProperty("sauce_username"),
						ConfigReader.getProperty("sauce_password"));
		
		// Action
		inventoryPage.addProductToCart("Sauce Labs Backpack");
		inventoryPage.addProductToCart("Sauce Labs Bike Light");
		inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");
		
		// Assertion
		Assert.assertEquals(inventoryPage.getCartBadgeCount(),
				"3",
				"Cart badge count should match add items");
	}

}
