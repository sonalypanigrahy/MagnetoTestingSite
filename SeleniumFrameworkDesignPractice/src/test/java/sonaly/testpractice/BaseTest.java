package sonaly.testpractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyautomationacademy.SeleniumFrameworkDesignPractice.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landPage;
	public WebDriver initializeDriver() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeMethod
	public LandingPage launchApplication() throws InterruptedException, IOException {
		driver = initializeDriver();
		landPage = new LandingPage(driver);
		landPage.goTo();
		return landPage;
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	public String screenshot(String string,WebDriver driver) throws IOException 
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File ("C:\\Users\\sonal\\OneDrive\\Desktop\\test.png"));
		return System.getProperty("C:\\Users\\sonal\\OneDrive\\Desktop\\test.png");
	}

}
