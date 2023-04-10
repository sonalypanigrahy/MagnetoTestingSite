package WebDriver;

import static Helpers.Constants.CHROMEDRIVERKEY;
import static Helpers.Constants.CHROMEDRIVERVALUE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSetup {
	public static WebDriver SetupWebDriver()
	{
		ChromeOptions objChromeOptions = new ChromeOptions();
		objChromeOptions.addArguments("--remote-allow-origins=*");
		System.setProperty(CHROMEDRIVERKEY, CHROMEDRIVERVALUE);
		return new ChromeDriver(objChromeOptions);
	}
	
}
