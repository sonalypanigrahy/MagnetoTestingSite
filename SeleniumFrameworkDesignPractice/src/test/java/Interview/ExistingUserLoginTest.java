package Interview;

import static Helpers.Constants.EMAIL;
import static Helpers.Constants.PASSWORD;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import BaseClassesInterviewPractice.LoginPage;

public class ExistingUserLoginTest extends BaseTest  {
	
	@Test
	public void Login() throws IOException
	{
	LoginPage objLoginPage=objLandingPage.GoToSignIn();
	objLoginPage.Login(EMAIL, PASSWORD);
	TakeScreenshot("LoginPage");
	}
	@AfterTest
	public void CleanUp()
	{
		objWebDriver.close();
	}
}	
