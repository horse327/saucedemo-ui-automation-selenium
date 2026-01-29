package base;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp () {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions ();
		options.addArguments("--disable-nofitications");
		options.addArguments("--disable-infobars");
		
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("sauce_url"));
		
	}
	
	protected void takeScreenshot(String testName) {
		try {
			File screenshotsDir = new File(System.getProperty("user.dir") + "/screenshots");
			if (!screenshotsDir.exists()) {
				screenshotsDir.mkdirs();
			}
			
			String timestamp = LocalDateTime.now()
					.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destination = new File(
					screenshotsDir + "/" + testName + "_" + timestamp + ".png");
			
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot saved: " + destination.getAbsolutePath());
			
		} catch (IOException e ) {
			System.err.println("Failed to capture screenshot: " + e.getMessage());
		}
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
		takeScreenshot (result.getTestName());
	}
	
		if (driver !=null) {
		driver.quit();
		}
	
	}
}
