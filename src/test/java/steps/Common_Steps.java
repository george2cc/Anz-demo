package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Constant;

public class Common_Steps {

	protected static WebDriver driver;

	// initialize timeouts
	private static WebDriverWait waitDriver;
	public final static int TIMEOUT = 30;
	public final static int PAGE_LOAD_TIMEOUT = 50;

	@Before(order = 0)
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", Constant.PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		waitDriver = new WebDriverWait(driver, TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		System.out.println("Global Before Hook Executed");
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			// Take Screenshot
			final byte[] shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// Embed into Report
			scenario.embed(shot, "image/png", scenario.getName());
		}
		if (driver != null) {
			driver.close();
			driver.quit();
		}
		Thread.sleep(1000);
		System.out.println("Global After Hook Executed");
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
    public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
    }
    
    
}