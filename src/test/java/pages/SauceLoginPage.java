package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceLoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	// Locators
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessage = By.cssSelector("[data-test='error']");
	private By inventoryContainer = By.id("inventory_container");
	
	public SauceLoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	public void login(String user, String pass) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		
	}
	
	public boolean isInventoryPageVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer)).isDisplayed();
		
	}
	
	public String getErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
	}
	
		public boolean isErrorDisplayed() {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
		}
}
