package karthikakkasaligar.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import karthikakkasaligar.PageObjectModel.HomePage;

public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;
	public HomePage homepage;

	public WebDriver intializedriver() throws IOException {

		Properties properties = new Properties();
		FileInputStream FIS = new FileInputStream(
				"C:\\Users\\karth\\eclipse-workspace\\AutomationExcerise\\src\\main\\java\\karthikakkasaligar\\GlobalData\\Globaldata.properties");
		properties.load(FIS);
		String browsername = properties.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) 
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			driver = new FirefoxDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeMethod
	public HomePage launchApplication() throws IOException {
		driver = intializedriver();
		homepage = new HomePage(driver, wait);
		homepage.GoTo();
		return homepage;
	}

	@AfterMethod
	public void closeapplication() {
		driver.quit();
	}

}
