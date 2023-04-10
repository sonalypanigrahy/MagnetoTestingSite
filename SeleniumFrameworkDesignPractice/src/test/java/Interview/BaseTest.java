package Interview;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import static Helpers.Constants.URL;

import java.io.File;
import java.io.IOException;
import BaseClassesInterviewPractice.LandingPage;
import WebDriver.WebDriverSetup;

public class BaseTest {
	static WebDriver objWebDriver;
	LandingPage objLandingPage;
	@BeforeSuite
	public void InitializeDriver() {
		// TODO Auto-generated method stub
		objWebDriver=WebDriverSetup.SetupWebDriver();
		objWebDriver.manage().window().maximize();
		objLandingPage=new LandingPage(objWebDriver);
		objLandingPage.GetURL(URL);
	}
	public void TakeScreenshot(String fileName) throws IOException
	{
		File src= ((TakesScreenshot)objWebDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\sonal\\OneDrive\\Desktop\\ScreenshotFolder\\"+fileName+".png"));
	}
}