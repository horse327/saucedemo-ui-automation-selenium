package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceInventoryPage {
	private WebDriverWait wait;
	
	
	
	private By cartBadge = By.cssSelector(".shopping_cart_badge");
	
	
	public SauceInventoryPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	private By addToCartButtonByProductName(String productName) {
		return By.xpath("//div[@class='intentory_item_name' and text()='" + productName + "']" +
						"/ancestor::div[@class='inventory_item']//button");
	}

	
	public void addProductToCart(String productName) {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonByProductName(productName))
				).click();
	}
	
	
	public String getCartBadgeCount() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText();
	}
	
	
	public boolean isCartBadgeDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge))
				.isDisplayed();
	}

}
